package com.wowoohr.calculators.common.security;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * A Sha256Hash just wraps a byte[] so that equals and hashcode work correctly, allowing it to be used as keys in a
 * map. It also checks that the length is correct and provides a bit more type safety.
 */
public class Sha256Hash implements Serializable, Comparable<Sha256Hash> {
    private final byte[] bytes;
    public static final Sha256Hash ZERO_HASH = wrap(new byte[32]);

    /**
     * Use {@link #wrap(byte[])} instead.
     */
    @Deprecated
    public Sha256Hash(byte[] rawHashBytes) {
        Preconditions.checkArgument(rawHashBytes.length == 32);
        this.bytes = rawHashBytes;
    }

    /**
     * Use {@link #wrap(String)} instead.
     */
    @Deprecated
    public Sha256Hash(String hexString) {
        Preconditions.checkArgument(hexString.length() == 64);
        this.bytes = EncoderUtils.decodeHex(hexString);
    }

    /**
     * Creates a new instance that wraps the given hash value.
     *
     * @param rawHashBytes the raw hash bytes to wrap
     * @return a new instance
     * @throws IllegalArgumentException if the given array length is not exactly 32
     */
    @SuppressWarnings("deprecation") // the constructor will be made private in the future
    public static Sha256Hash wrap(byte[] rawHashBytes) {
        return new Sha256Hash(rawHashBytes);
    }

    /**
     * Creates a new instance that wraps the given hash value (represented as a hex string).
     *
     * @param hexString a hash value represented as a hex string
     * @return a new instance
     * @throws IllegalArgumentException if the given string is not a valid
     *         hex string, or if it does not represent exactly 32 bytes
     */
    public static Sha256Hash wrap(String hexString) {
        return wrap(EncoderUtils.decodeHex(hexString));
    }

    /**
     * Creates a new instance that wraps the given hash value, but with byte order reversed.
     *
     * @param rawHashBytes the raw hash bytes to wrap
     * @return a new instance
     * @throws IllegalArgumentException if the given array length is not exactly 32
     */
    @SuppressWarnings("deprecation") // the constructor will be made private in the future
    public static Sha256Hash wrapReversed(byte[] rawHashBytes) {
        return wrap(reverse(rawHashBytes));
    }

    
    /**
     * ????????????byte[]???????????????
     */
    public static byte[] reverse(byte[] bytes) {
        byte[] buf = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++)
            buf[i] = bytes[bytes.length - 1 - i];
        return buf;
    }
    
    /** Use {@link #of(byte[])} instead: this old name is ambiguous. */
    @Deprecated
    public static Sha256Hash create(byte[] contents) {
        return of(contents);
    }

    /**
     * Creates a new instance containing the calculated (one-time) hash of the given bytes.
     *
     * @param contents the bytes on which the hash value is calculated
     * @return a new instance containing the calculated (one-time) hash
     */
    public static Sha256Hash of(byte[] contents) {
        return wrap(hash(contents));
    }

    /** Use {@link #twiceOf(byte[])} instead: this old name is ambiguous. */
    @Deprecated
    public static Sha256Hash createDouble(byte[] contents) {
        return twiceOf(contents);
    }

    /**
     * Creates a new instance containing the hash of the calculated hash of the given bytes.
     *
     * @param contents the bytes on which the hash value is calculated
     * @return a new instance containing the calculated (two-time) hash
     */
    public static Sha256Hash twiceOf(byte[] contents) {
        return wrap(hashTwice(contents));
    }

    /**
     * Creates a new instance containing the calculated (one-time) hash of the given file's contents.
     *
     * The file contents are read fully into memory, so this method should only be used with small files.
     *
     * @param file the file on which the hash value is calculated
     * @return a new instance containing the calculated (one-time) hash
     * @throws IOException if an error occurs while reading the file
     */
    public static Sha256Hash of(File file) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            return of(ByteStreams.toByteArray(in));
        }
    }

    /**
     * ??????????????? SHA-256 MessageDigest??????(????????????)
     * @return MessageDigest
     */
    public static MessageDigest newDigest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);  // ????????????????????????
        }
    }

    /**
     * Calculates the SHA-256 hash of the given bytes.
     *
     * @param input the bytes to hash
     * @return the hash (in big-endian order)
     */
    public static byte[] hash(byte[] input) {
        return hash(input, 0, input.length);
    }

    /**
     * Calculates the SHA-256 hash of the given byte range.
     *
     * @param input the array containing the bytes to hash
     * @param offset the offset within the array of the bytes to hash
     * @param length the number of bytes to hash
     * @return the hash (in big-endian order)
     */
    public static byte[] hash(byte[] input, int offset, int length) {
        MessageDigest digest = newDigest();
        digest.update(input, offset, length);
        return digest.digest();
    }

    /**
     * Calculates the SHA-256 hash of the given bytes,
     * and then hashes the resulting hash again.
     *
     * @param input the bytes to hash
     * @return the double-hash (in big-endian order)
     */
    public static byte[] hashTwice(byte[] input) {
        return hashTwice(input, 0, input.length);
    }

    /**
     * Calculates the SHA-256 hash of the given byte range,
     * and then hashes the resulting hash again.
     *
     * @param input the array containing the bytes to hash
     * @param offset the offset within the array of the bytes to hash
     * @param length the number of bytes to hash
     * @return the double-hash (in big-endian order)
     */
    public static byte[] hashTwice(byte[] input, int offset, int length) {
        MessageDigest digest = newDigest();
        digest.update(input, offset, length);
        return digest.digest(digest.digest());
    }

    /**
     * Calculates the hash of hash on the given byte ranges. This is equivalent to
     * concatenating the two ranges and then passing the result to {@link #hashTwice(byte[])}.
     */
    public static byte[] hashTwice(byte[] input1, int offset1, int length1,
                                   byte[] input2, int offset2, int length2) {
        MessageDigest digest = newDigest();
        digest.update(input1, offset1, length1);
        digest.update(input2, offset2, length2);
        return digest.digest(digest.digest());
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && Arrays.equals(bytes, ((Sha256Hash) o).bytes);
    }

    /**
     * Returns the last four bytes of the wrapped hash. This should be unique enough to be a suitable hash code even for
     * blocks, where the goal is to try and get the first bytes to be zeros (i.e. the value as a big integer lower
     * than the target value).
     */
    @Override
    public int hashCode() {
        // Use the last 4 bytes, not the first 4 which are often zeros in Bitcoin.
        return Ints.fromBytes(bytes[28], bytes[29], bytes[30], bytes[31]);
    }

    @Override
    public String toString() {
        return EncoderUtils.encodeHex(bytes);
    }

    /**
     * ???byte[]???????????????BigInteger????????????
     */
    public BigInteger toBigInteger() {
        return new BigInteger(1, bytes);
    }

    /**
     * Returns the internal byte array, without defensively copying. Therefore do NOT modify the returned array.
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * ????????????byte[]??????????????? --> new byte[]
     */
    public byte[] getReversedBytes() {
        return reverse(bytes);
    }

    @Override
    public int compareTo(Sha256Hash o) {
        // note that in this implementation compareTo() is not consistent with equals()
        return this.hashCode() - o.hashCode(); // arbitrary but consistent
    }
}

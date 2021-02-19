package net.certiv.tools.util.stores;

import java.util.IllegalFormatException;
import java.util.stream.IntStream;

/**
 * A {@link StringBuilder} analog adding a formatted append method.
 */
public class Sb {

	private final StringBuilder sb = new StringBuilder();

	public Sb() {
		super();
	}

	public Sb(String str) {
		sb.append(str);
	}

	/**
	 * Appends a formatted string using the specified format and arguments.
	 *
	 * @param format A {@link Formatter} syntax format
	 * @param args   Arguments referenced by the format specifiers in the format
	 * @throws IllegalFormatException if the format is invalid
	 * @return this
	 */
	public Sb append(String format, Object... args) {
		sb.append(String.format(format, args));
		return this;
	}

	public Sb append(Object obj) {
		sb.append(obj);
		return this;
	}

	public Sb append(String str) {
		sb.append(str);
		return this;
	}

	public Sb append(StringBuffer sb) {
		sb.append(sb);
		return this;
	}

	public Sb append(CharSequence s) {
		sb.append(s);
		return this;
	}

	public Sb append(CharSequence s, int start, int end) {
		sb.append(s, start, end);
		return this;
	}

	public Sb append(char[] str) {
		sb.append(str);
		return this;
	}

	public Sb append(char[] str, int offset, int len) {
		sb.append(str, offset, len);
		return this;
	}

	public Sb append(boolean b) {
		sb.append(b);
		return this;
	}

	public Sb append(char c) {
		sb.append(c);
		return this;
	}

	public Sb append(int i) {
		sb.append(i);
		return this;
	}

	public Sb append(long lng) {
		sb.append(lng);
		return this;
	}

	public Sb append(float f) {
		sb.append(f);
		return this;
	}

	public Sb append(double d) {
		sb.append(d);
		return this;
	}

	public Sb appendCodePoint(int codePoint) {
		sb.appendCodePoint(codePoint);
		return this;
	}

	public Sb delete(int start, int end) {
		sb.delete(start, end);
		return this;
	}

	public Sb deleteCharAt(int index) {
		sb.deleteCharAt(index);
		return this;
	}

	public Sb replace(int start, int end, String str) {
		sb.replace(start, end, str);
		return this;
	}

	public Sb insert(int index, char[] str, int offset, int len) {
		sb.insert(index, str, offset, len);
		return this;
	}

	public Sb insert(int offset, Object obj) {
		sb.insert(offset, obj);
		return this;
	}

	public Sb insert(int offset, String str) {
		sb.insert(offset, str);
		return this;
	}

	public Sb insert(int offset, char[] str) {
		sb.insert(offset, str);
		return this;
	}

	public Sb insert(int dstOffset, CharSequence s) {
		sb.insert(dstOffset, s);
		return this;
	}

	public Sb insert(int dstOffset, CharSequence s, int start, int end) {
		sb.insert(dstOffset, s, start, end);
		return this;
	}

	public Sb insert(int offset, boolean b) {
		sb.insert(offset, b);
		return this;
	}

	public Sb insert(int offset, char c) {
		sb.insert(offset, c);
		return this;
	}

	public IntStream chars() {
		return sb.chars();
	}

	public IntStream codePoints() {
		return sb.codePoints();
	}

	public char charAt(int index) {
		return sb.charAt(index);
	}

	public Sb insert(int offset, int i) {
		sb.insert(offset, i);
		return this;
	}

	public Sb insert(int offset, long l) {
		sb.insert(offset, l);
		return this;
	}

	public Sb insert(int offset, float f) {
		sb.insert(offset, f);
		return this;
	}

	public Sb insert(int offset, double d) {
		sb.insert(offset, d);
		return this;
	}

	public int indexOf(String str) {
		return sb.indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return sb.indexOf(str, fromIndex);
	}

	public int codePointAt(int index) {
		return sb.codePointAt(index);
	}

	public int lastIndexOf(String str) {
		return sb.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return sb.lastIndexOf(str, fromIndex);
	}

	public Sb reverse() {
		sb.reverse();
		return this;
	}

	public int codePointBefore(int index) {
		return sb.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return sb.codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return sb.offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		sb.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public void setCharAt(int index, char ch) {
		sb.setCharAt(index, ch);
	}

	public void setLength(int newLength) {
		sb.setLength(newLength);
	}

	public String substring(int start) {
		return sb.substring(start);
	}

	public CharSequence subSequence(int start, int end) {
		return sb.subSequence(start, end);
	}

	public String substring(int start, int end) {
		return sb.substring(start, end);
	}

	public int compareTo(StringBuilder another) {
		return sb.compareTo(another);
	}

	public int length() {
		return sb.length();
	}

	public int capacity() {
		return sb.capacity();
	}

	public void ensureCapacity(int minimumCapacity) {
		sb.ensureCapacity(minimumCapacity);
	}

	public void trimToSize() {
		sb.trimToSize();
	}

	@Override
	public int hashCode() {
		return sb.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return sb.equals(obj);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

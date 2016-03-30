package testing;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.Test;

public class BitTest extends TestCaseBase {

	@Test
	public void test() {

		int[] intArray = new int[10];

		set(intArray, 100, true);
		set(intArray, 0, true);

		// logln(bytes);

		assertEquals("The first byte should be one", 0x01, intArray[0]);
		assertEquals("The 12th byte should 0x10", 0x10, intArray[3]);

		set(intArray, 1, true);

		assertEquals("The first byte should be 3", 0x03, intArray[0]);

		assertEquals("The first byte should be 3", 2, get(intArray, 1));
		assertEquals("The first byte should be 3", 0, get(intArray, 3));

		set(intArray, 8, 8, true);
		set(intArray, 2, true);

		assertEquals("The first byte should be 3", 255 << 8, intArray[0] & 0X00FF00);

		logln(intArray);
		// logln(getBitsAsArray(intArray, 0, 2));
		logln(getBitsAsArray(intArray, 2, 1));
		// logln(getBitsAsArray(intArray, 1, 1));

		// logln("" + (0xffffffff >> 24));
		// logln("" + (0xffffffff));

		// logln("" + (0x0fff));

		// assertEquals("The first byte should be 3", 255 << 8, intArray[0] &
		// 0X00FF00);

		// assertEquals("The first byte should be 3",true,bset.get(0));

		// logln(bytes[0]);

	}

	static final int INT_LENGTH = 32;
	static final int SHIFT_COUNT = 5;
	static final int INT_MASK = 0xFFFFFFFF;

	public int abs(int value) {
		return value >= 0 ? value : -value;
	}

	public int[] getBitsAsArray(int[] intArray, int start, int offset) {
		if (offset <= 0) {
			return null; // do nothing when the offset equals 0;
		}
		assert((start + offset) <= (intArray.length << 5));

		int startIntIndex = start >> SHIFT_COUNT;
		int endIntIndex = (start+offset) >> SHIFT_COUNT;

		int finalLength=endIntIndex-startIntIndex+1;
		int ret[] = new int[finalLength];
		int index = 0;

		while (index < finalLength) {
			ret[index] = intArray[startIntIndex + index];
			index++;
		}
		
		int maskLow = INT_MASK << (start % INT_LENGTH);
		int maskHigh = ~(INT_MASK << ((start % INT_LENGTH) + offset));

		int headremain = INT_LENGTH - (start % INT_LENGTH); // high bit remain
		int tailremain = (start+offset) % INT_LENGTH;
		
		if (headremain > 0) {
			ret[0] &= maskLow;
		}
		if (tailremain > 0) {
			ret[finalLength - 1] &= maskHigh;
		}
		return ret;

	}

	public int get(int[] intArray, int offset) {

		assert(offset < intArray.length << SHIFT_COUNT);
		// int offset=100;
		int remain = offset % INT_LENGTH;
		int byteOffset = (offset - remain) >> SHIFT_COUNT;
		return (intArray[byteOffset] & (1 << remain));

		// intArray[byteOffset] &= ~(1<<remain);

	}

	public void set(int[] intArray, int start, boolean value) {

		assert(start < intArray.length << SHIFT_COUNT);
		// int offset=100;
		int remain = start % INT_LENGTH;
		int byteOffset = (start - remain) >> 5;

		// byte one=intArray[byteOffset];
		if (value) {
			intArray[byteOffset] |= (1 << remain);
			return;
		}
		intArray[byteOffset] &= ~(1 << remain);

	}

	private boolean hasNextInt(int currentPos, int start, int offset) {
		if (currentPos % INT_LENGTH != 0) {
			return false;
		}
		if ((currentPos + INT_LENGTH) > (start + offset)) {
			return false;
		}

		return true;

	}

	public void set(int[] intArray, int start, int offset, boolean value) {
		if (offset == 0) {
			return; // do nothing when the offset equals 0;
		}

		assert((start + offset - 1) < intArray.length << 5);
		for (int i = start; i < start + offset;) {
			if (hasNextInt(i, start, offset)) {

				intArray[i >> SHIFT_COUNT] = (value) ? INT_MASK : 0x00;
				// logln("here!");
				i += INT_LENGTH;
				continue;
			}

			set(intArray, i, value);
			i++;
			// this can be optimized to use byte instead when the bytes aligned
		}
	}

}

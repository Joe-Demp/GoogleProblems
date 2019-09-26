package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import problems.StringDecompressor;

class StringDecompressorTest {

	@Test
	final void testDecompressEmpty() {
		assertEquals("", StringDecompressor.decompress(""));
	}
	
	@Test
	final void testDecompress1() {
		assertEquals("abcabcabcababababc", StringDecompressor.decompress("3[abc]4[ab]c"));
	}
	
	@Test
	final void testDecompress2() {
		assertEquals("aaaaaaaaaa" , StringDecompressor.decompress("10[a]"));
	}
	
	@Test
	final void testDecompress3() {
		assertEquals("aaabaaab" , StringDecompressor.decompress("2[3[a]b]"));
	}
	
	@Test
	final void testDecompress4() {
		assertEquals("ab" , StringDecompressor.decompress("a[]b"));
	}
	
	@Test
	final void testDecompress5() {
		assertEquals("", StringDecompressor.decompress("0[abc]"));
	}
}

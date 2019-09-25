package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

}

/**
Question:
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there
is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n
characters from the file.
Note: The read function will only be called once for each test case.
Solution:
This seemingly easy coding question has some tricky edge cases. When read4 returns
less than 4, we know it must reached the end of file. However, take note that read4
returning 4 could mean the last 4 bytes of the file.
To make sure that the buffer is not copied more than n bytes, copy the remaining bytes
(n � readBytes) or the number of bytes read, whichever is smaller.
 */
package chp1_ArrayAndString;

/**
 * @author iflee
 *
 */
public class ReadNCharactersGivenRead4 extends Reader4 {

/* The read4 API is defined in the parent class Reader4.
 * 	public int read4(char[] buf); // read4 saves 4 char to buf ?
/*
// public class Solution extends Reader4 {

* @param buf Destination buffer
* @param n Maximum number of characters to read
* @return The number of characters read
*/
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean EOF = false;
		
		while(!EOF && readBytes < n){
			int size = read4(buffer); // source doc in read4
			
			// about to EOF
			if(size < 4){EOF = true;}
			int bytes = Math.min(size, n - readBytes);
			readBytes += bytes;
			//System.arraycopy(src, srcPos, dest, destPos, length);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
		}
		
		return readBytes;

	}
}

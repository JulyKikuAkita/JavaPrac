/**********************************************************************
Question:
Similar to Question [15. Read N Characters Given Read4], but the read function may be
called multiple times.
 */
package chp1_ArrayAndString;

/**
Solution:
This makes the problem a lot more complicated, because it can be called multiple times
and involves storing states.
Therefore, we design the following class member variables to store the states:
i. buffer � An array of size 4 use to store data returned by read4 temporarily. If
the characters were read into the buffer and were not used partially, they will
be used in the next call.
ii. offset � Use to keep track of the offset index where the data begins in the next
read call. The buffer could be read partially (due to constraints of reading up
to n bytes) and therefore leaving some data behind.
iii. bufsize � The real buffer size that stores the actual data. If bufsize > 0, that
means there is partial data left in buffer from the last read call and we should
consume it before calling read4 again. On the other hand, if bufsize == 0, it
means there is no data left in buffer.
This problem is a very good coding exercise. Coding it correctly is extremely tricky due
to the amount of edge cases to consider.
 *
 ********************************************************************/

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */
public class ReadNCharactersGivenRead4Callmultipletimes extends Reader4{
	private char[] buffer = new char[4];
	int offset = 0, bufsize = 0;
	
	/**
	* @param buf Destination buffer
	* @param n Maximum number of characters to read
	* @return The number of characters read
	*/
	public int read(char[] buf, int n) {
		boolean eof = false;
		int readBytes = 0;
		
		// read data from buf
		while(!eof && readBytes < n){
			int sz = (bufsize > 0 )? bufsize : read4(buffer);
			if(bufsize == 0 && sz < 4){eof = true;}
			int bytes = Math.min(sz, n - readBytes) ;
			// System.arraycopy(src, srcPos, dest, destPos, length)
			System.arraycopy(buffer, offset, buf, readBytes, bytes);
			offset = (offset + bytes) % 4;
			bufsize = sz - bytes;
			readBytes += bytes;
		}
		return readBytes;
	}
	

}

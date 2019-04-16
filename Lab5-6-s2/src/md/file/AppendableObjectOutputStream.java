package md.file;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Used for appending data to a file
 * 
 * @author Fanncy
 *
 */
public class AppendableObjectOutputStream extends ObjectOutputStream {
	// constructor
	protected AppendableObjectOutputStream(OutputStream out) throws IOException, SecurityException {
		super(out);
	}

	/**
	 * New version of this method will not create new header to the file
	 */
	@Override
	protected void writeStreamHeader() throws IOException {
		reset();
	}
}

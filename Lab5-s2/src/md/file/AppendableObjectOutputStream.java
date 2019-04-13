package md.file;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

//pentru a putea face append fara a scrie un nou header in file
public class AppendableObjectOutputStream extends ObjectOutputStream{

	protected AppendableObjectOutputStream(OutputStream out) throws IOException, SecurityException {
		super(out);
	}

	 @Override
	  protected void writeStreamHeader() throws IOException {
	    reset();
	  }
}

package pixeng;
import java.io.IOException;

public interface NetListener
{
	public void onConnect(Connection connection) throws IOException ;
	public void onReceive(Object object, Connection connection) throws IOException ;
}

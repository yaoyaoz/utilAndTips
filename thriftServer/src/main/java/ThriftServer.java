import generated.PersonService;
import impl.PersonServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by yaoyao on 2019/8/28.
 */
public class ThriftServer {
    public static void main(String[] args) {
        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(8899);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        //范型就是实现的接收类
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        //表示协议层次（压缩协议）
        arg.protocolFactory(new TCompactProtocol.Factory());
        //表示传输层次
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        //半同步半异步的server
        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server started!");

        //死循环，永远不会退出
        server.serve();
    }
}

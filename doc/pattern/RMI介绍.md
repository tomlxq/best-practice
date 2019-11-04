# RMI使用介绍

## 制作远程接口：接口文件`RemoteService.java`

```java
public interface RemoteService extends Remote {
   String sayHello() throws RemoteException;
}
```

## 远程接口的实现：service文件`RemoteServiceImpl.java`

```java
@SuppressWarnings("Serial")
public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
    protected RemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "hello,world";
    }
}
```

## RMI服务端注册开启服务`Server.java`

```java
public class Server {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "192.168.56.1");
        try {
            RemoteService remoteService = new RemoteServiceImpl();
            LocateRegistry.createRegistry(6060);
            Naming.rebind("//192.168.56.1:6060/RemoteHello", remoteService);
            System.out.println("注册服务启动了");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
```

## 客户端调用`Client.java`

RMI代理端通过RMI查询到服务端，建立联系，通过接口调用远程方法。

```java
public class Client {
    public static void main(String[] args) {
        try {
            RemoteService remoteService=(RemoteService) Naming.lookup("rmi://192.168.56.1:6060/RemoteHello");
            System.out.println(remoteService.sayHello()); ;
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
```


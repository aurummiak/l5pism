import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null); //создаем и инициализируем ORB

            // get reference to rootpoa & activate the POAManager
            //устанавливаем связь и активируем POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            RandomOutServer server = new RandomOutServer(); // создаем сервант

            // get object reference from the servant
            // доступ к объекту сервант
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(server);
            RandomOut ent = RandomOutHelper.narrow(ref);

            //получаем корневой контекст наименования
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef); //связываем индификатор и объект серванта

            NameComponent path[] = ncRef.to_name("Random_SERVER");
            ncRef.rebind(path, ent);

            System.out.println("Server ready and waiting ...");

            // ждем подключения клиентов
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Exiting ...");

    }


}


import SticksCORBAApp.SticksCORBA;
import SticksCORBAApp.SticksCORBAHelper;
import SticksCORBAPackage.SticksCORBAObj;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import sticksgame.GamePanel;

public class SticksServer {

    public static void main(String args[]) {
        try {
            // create and initialize the ORB //
            // get reference to rootpoa &amp;
            //activate the POAManager
            ORB orb = ORB.init(args, null);
            //Some object, which contains methods to work with 
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB           
            SticksCORBAObj sticksCORBAObj = new SticksCORBAObj();
            sticksCORBAObj.setORB(orb);

            // get object reference from the servant            
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(sticksCORBAObj);
            SticksCORBA href = SticksCORBAHelper.narrow(ref);

            // get namecontext
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); //CORBA - объект ссылка на службу имен          
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef); //Конкретизация

            NameComponent path[] = ncRef.to_name("Sticks");//Регистрация имени
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting ...");

            GamePanel gamePanel = new GamePanel();
            sticksCORBAObj.setGamePanel(gamePanel);

            // wait for invocations from clients
            orb.run();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("Server Exiting ...");
    }
}

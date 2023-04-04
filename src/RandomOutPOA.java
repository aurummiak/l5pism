
/**
* RandomOutPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RandomOut.idl
* 4 ������ 2023 �. 23:25:20 MSK
*/

public abstract class RandomOutPOA extends org.omg.PortableServer.Servant
 implements RandomOutOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("addWords", new java.lang.Integer (0));
    _methods.put ("getLetters", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // RandomOut/addWords
       {
         String word = in.read_string ();
         this.addWords (word);
         out = $rh.createReply();
         break;
       }

       case 1:  // RandomOut/getLetters
       {
         String res = in.read_string ();
         String $result = null;
         $result = this.getLetters (res);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:RandomOut:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public RandomOut _this() 
  {
    return RandomOutHelper.narrow(
    super._this_object());
  }

  public RandomOut _this(org.omg.CORBA.ORB orb) 
  {
    return RandomOutHelper.narrow(
    super._this_object(orb));
  }


} // class RandomOutPOA
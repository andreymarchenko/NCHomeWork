package SticksCORBAApp;


/**
* SticksCORBAApp/SerializedObjectHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SticksCORBA.idl
* 6 ������� 2016 �. 12:53:07 MSK
*/

public final class SerializedObjectHolder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public SerializedObjectHolder ()
  {
  }

  public SerializedObjectHolder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = SticksCORBAApp.SerializedObjectHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    SticksCORBAApp.SerializedObjectHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return SticksCORBAApp.SerializedObjectHelper.type ();
  }

}

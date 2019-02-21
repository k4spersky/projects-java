package napiers;

import napiers.methods.*;

/**
 * Factory for Napiers methods. Provides a method given input.
 */
public class NapiersMethodsFactory {

    protected NapiersMethodsBase getNapiersMethod(String mtype)
    {
        NapiersMethodsBase nmethod = null;
        switch (mtype)
        {
            case "1":
                nmethod = new LocationNumeralToInt();
                break;
            case "2":
                nmethod = new IntToLocationNumeral();
                break;
            case "3":
                nmethod = new LocationNumeralAbbrev();
                break;
        }
        return nmethod;
    }
}

package java112.project3;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class BeanOne extends java.lang.Object {

    private  String  mySpecialData;


    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
//        data  = "default value";
        mySpecialData  = "default value";
    }


    /**
     *  Gets the Data attribute of the BeanOne object
     *
     *@return    The Data value
     */
    public String getMySpecialData() {
//        return data;
        return mySpecialData;
    }


    /**
     *  Sets the Data attribute of the BeanOne object
     *
     *@param  data  The new Data value
     */
    public void setMySpecialData(String mySpecialData) {
        this.mySpecialData = mySpecialData;
    }

}


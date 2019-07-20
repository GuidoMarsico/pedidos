package nav.api.pedidos.cache;

/*** Se encargaria de tener en memoria los pedidos, 
 	 para no estar haciendo tantas peticiones a la db.
 	 No se realiza implementacion por el momento.  
***/
public class BumexMemcached {
    private static BumexMemcached ourInstance = new BumexMemcached();

    public static  synchronized  BumexMemcached getInstance() {
        return ourInstance;
    }

    public void set(String key,Object value){
      /** No se pide implementacion **/
    }

    public void delete(String key){
        /** No se pide implementacion **/
    }

    public Object get(String key){
        /** No se pide implementacion **/
        return null;
    }


}

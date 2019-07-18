package nav.api.pedidos.cache;

public class BumexMemcached {
    private static BumexMemcached ourInstance = new BumexMemcached();

    public synchronized static BumexMemcached getInstance() {
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

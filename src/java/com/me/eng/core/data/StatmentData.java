package com.me.eng.core.data;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentData 
{
    public enum Type
    {
        MIXED()
        {
            @Override
            public String toString() 
            {
                return "INSERT/SELECT";
            }
          
        },
        
        HTTP()
        {
            @Override
            public String toString() {
                return "HTTP - GET";
            }
            
        },
        
        APACHE_AB(){
            @Override
            public String toString() {
                return "APACHE AB";
            }
        }
    }
    
    private String sql;
    private int user;
    private int quantidade;
    private int paginas;
    private int timeout;
    private Type type;

    public StatmentData(String sql, int user, int quantidade, int timeout, int paginas, Type type) 
    {
        this.sql = sql;
        this.user = user;
        this.quantidade = quantidade;
        this.paginas = paginas;
        this.timeout = timeout;
        this.type = type;
    }


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}

package com.me.eng.core.data;

/**
 *
 * @author Artur Tomasi
 */
public class StatmentData 
{
    public enum Type
    {
        QUERY, COMMAND, INSERT
    }
    
    private String sql;
    private int user;
    private int quantidade;
    private Type type;

    public StatmentData(String sql, int user, int quantidade, Type type) {
        this.sql = sql;
        this.user = user;
        this.quantidade = quantidade;
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
    
    
}

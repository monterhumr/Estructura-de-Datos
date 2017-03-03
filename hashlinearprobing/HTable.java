package hashlinearprobing;

import java.math.BigInteger;																						//Para poder usar el KEY, que es un String con su valor en ASCII

public class HTable {

    private final static int TABLE_SIZE = 29;																		//Define el tamaño de la tabla, se usa como MOD (29 es un numero primo
    Entry[] htable;

    HTable() {
          htable = new Entry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                htable[i] = null;
    }

    public int Search(String key) {
          int hash = new BigInteger(ToAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();	//Regresa la "DATA" de un ENTRY a partir de aplicar HASH a KEY
          while (htable[hash] != null && htable[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (htable[hash] == null)
                return -1;
          else
                return htable[hash].getData();
    }
    
    public String listaF(){
    	String listafin = "";
    	for(int i =0; i<TABLE_SIZE; i++){
    		if (htable[i]!=null){
    			listafin+=(htable[i].getKey()+" ");
    			listafin+=(htable[i].getData())+"\n";
    		}
    	}
    	return listafin;
    }

    public void Write(String key, int data) {																			//Añade una DATA a la TABLA, pide KEY y el valor DATA

          int hash = new BigInteger(ToAscii(key)).mod(new BigInteger(((Integer)TABLE_SIZE).toString())).intValue();
          while (htable[hash] != null && htable[hash].getKey() != key)
        	  hash = (hash + 1) % TABLE_SIZE;
          htable[hash] = new Entry(key, data);
    }

    public static String ToAscii(String skey){																		//Convierte la KEY tipo string en su valor ACII (int)
        StringBuilder sb = new StringBuilder();
        int asciiInt;

        for (int i = 0; i < skey.length(); i++){																	//Busca cada valor de los caracteres del String

            char c = skey.charAt(i);
            asciiInt = (int)c; 
            sb.append(asciiInt);
            
        }
        return String.valueOf(sb);
    }
}
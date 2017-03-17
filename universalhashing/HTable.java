import java.math.BigInteger;
import java.util.Random;


public class HTable {

    private final static int TABLE_SIZE = 29;																				//Define el tamaño de la tabla, se usa como MOD (29 es un numero primo
    Entry[] htable;
    Entry aux = new Entry(null, 0);

    public HTable() {
          htable = new Entry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                htable[i] = aux;  		
    }
    
    public void write(String key, int data) {																			//Añade una DATA a la TABLA, pide KEY y el valor DATA
    	int ranP = getPrime();
    	int hash = new BigInteger(toAscii(key)).mod(new BigInteger(((Integer)ranP).toString())).intValue();//keyAscii % ranP
    	while (htable[hash] != aux && htable[hash].getKey() != key)
        	hash = (hash + 1) % ranP;
        htable[hash] = new Entry(key, data);
        
    }
    
    public String print(){
    	String table = "";
    	for(int i =0; i<TABLE_SIZE; i++){
    		table+=(htable[i].getKey()+" ");
    		table+=(htable[i].getData())+"\n";
    		
    	}
    	return table;
    }
	
    public static int getPrime(){
    	int[] primesList = {7, 11, 13, 17, 19, 23, 29};
    	int min = 0;
	    int max = 6;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
    	int prime = primesList[randomNum];
    	return prime;
    }
	
    public static String toAscii(String skey){																				//Convierte la KEY tipo string en su valor ACII (int)
        StringBuilder sb = new StringBuilder();
        int asciiInt;

        for (int i = 0; i < skey.length(); i++){																			//Busca cada valor de los caracteres del String

            char c = skey.charAt(i);
            asciiInt = (int)c; 
            sb.append(asciiInt);
        }
        return String.valueOf(sb);
    }
    
}

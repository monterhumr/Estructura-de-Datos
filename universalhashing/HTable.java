import java.util.Random;

public class HTable {

    private final static int TABLE_SIZE = 29;																				//Define el tamaño de la tabla, se usa como MOD (29 es un numero primo
    Entry[] htable;
    Entry aux = new Entry(0, 0);
    int p = 977;

    public HTable() {
          htable = new Entry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                htable[i] = aux;  		
    }
    
    public void write(int key, int data) {																			//Añade una DATA a la TABLA, pide KEY y el valor DATA
    	int a = getRandomA();
    	int b = getRandomB();
    	int hash = ((a * key+b)%p)%TABLE_SIZE;
    	while (htable[hash] != aux && htable[hash].getKey() != key)
        	hash = (hash + 1) % TABLE_SIZE;
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
	
    public static int getRandomA(){
    	int min = 1;
	    int max = 29;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
    public static int getRandomB(){
    	int min = 0;
	    int max = 29;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
    	return randomNum;
    }
    
}

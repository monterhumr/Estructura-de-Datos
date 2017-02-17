package linkedlist;

import java.util.NoSuchElementException;

public class SLinkedList<E> implements LinkList<E> {
	
	private Node<E> firstNode;
	private int size;
	
	public SLinkedList (){		//Constructor por default
		firstNode=null;			//Primer nodo vacio
		size=0;					//Tamaño 0
	}
	
	public boolean isEmpty(){	//Comprueba si la lista está vacia
		return size==0;			//Regresa ture si lo esta, false si no
	}
	
	public int size(){
		return size;
	}
	
	public E getFirst(){					//Obtiene el primer elemento de la lista
		if(firstNode != null){
			return firstNode.getData();
		}
		else{
			throw new NoSuchElementException ("No hay ningun elemento en la lista.");		//Si está vacía devuelve esta excepción
		}
	}
	
	public void addFirst(E data){		//Agrega un nodo al principio
		this.firstNode=new Node<E>(data,this.firstNode);
		this.size++;
	}
	
	public void add(int index, E data){		//Agrega un nodo en el índice que se indique, siempre y cuando este en el rango de la lista
		if(index<0||index>this.size){									
			throw new IndexOutOfBoundsException("Indice invalido.");
		}
		if(index==0){
			addFirst(data);
		}
		else{
			Node<E> ant=this.firstNode;
			
			for(int i=0; i<index-1; i++){
				ant=ant.getNext();
			}
			
			Node<E> nuevo=new Node<E>(data, ant.getNext());
			ant.setNext(nuevo);
			this.size++;
		}
	
	}
	
	public boolean contains(E item){	//regresa true si el elemento que se pidió está en la lista, false si no
			int a=this.indexOf(item);
			return a !=-1;
	}
	
	public int indexOf(E item){			//regresa el índice del elemento solicitado, si es que está en la lista
		if(size!=0){
			Node<E> n;
			int aux=0;
			n=this.firstNode;
			while(aux<=size){
				if(item.equals(n.getData())){
					return aux;
				}
				n=n.getNext();
				aux++;
			}
		}
		return -1;
	}
	
	public E get (int index){		//Accede al objeto dentro de un nodo en cualquier posicion existente de la lista
		if(index<0||index>=this.size){
			throw new IndexOutOfBoundsException("Indice no valido");
		}
		Node<E> n;
		int aux=0;
		n=this.firstNode;
		while(aux<index){
			n=n.getNext();
			aux++;
		}
		return n.getData();
	}
	
	public E remove(int index){			//Elimina un nodo en cualquier posicion existente de la lista
		if(index<0||index>=this.size){
			throw new IndexOutOfBoundsException("Indice no valido");
		}
		
		Node<E> ant=this.firstNode;
		
		for(int i=0; i<index-1; i++){
			ant=ant.getNext();
		}
		
		E data=ant.getNext().getData();
		
		Node<E> nextNode=ant.getNext().getNext();
		ant.setNext(nextNode);
		size--;
		return data;
	}
	
	public String toString(){				//Convierte la lista a un string para fines de outputs
		if(size==0){
			return "";
		}
		else{
			StringBuilder sb = new StringBuilder();
			Node<E> actual = this.firstNode;
			for(int i=0; i<this.size; i++){
				sb.append("["+actual.getData()+"] ");
				actual=actual.getNext();
			}
			return sb.toString();
		}
	}
	
}


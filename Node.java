package linkedlist;

public class Node<E> {
	private E data;
	private Node<E> next;
	
	public Node (){					//Constructor por default
		this (null,null);
	}
	
	public Node (E data, Node<E> next){		//Asigna valores de los parametros
		this.data=data;
		this.next=next;
	}
	
	public E getData(){						//Obtiene el valor del elemento en el nodo
		return data;
	}
	
	public void setData(E data){			//Asigna el valor a la variable data
		this.data = data;
	}
	
	public Node<E> getNext(){				//Obtiene a qué nodo apunta
		return next;
	}
	
	public void setNext(Node<E> node){		//Define a qué nodo apunta
		this.next = node;
	}
	
}


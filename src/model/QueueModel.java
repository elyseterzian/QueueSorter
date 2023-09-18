package model;

import view.QueueForm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueModel <T>{
    private Queue<T> queue;

    //constructor
    public QueueModel(){
        this.queue = new LinkedList<>();
    }

    public QueueModel(QueueModel o){
        this.queue = new LinkedList<>();
        queue.addAll(o.getWrappedQueue());
    }


    //O(1)
    //adds T type element to the queue
    public void enqueue(T element){
        queue.add(element);
    }

    //O(1)
    //removes the head of this queue, or returns null if this queue is empty
    public T dequeue(){
        return queue.poll();
    }

    //O(1)
    //retrieves the head of the queue
    public T peekFront(){
        return queue.peek();
    }

    //O(n)
    // iterate through entire queue to get rear element
    public T peekRear(){
        T rear = null;
        for (T element : this.queue){
            rear = element;
        }
        return rear;
    }


    public Queue<T> getWrappedQueue(){
        return this.queue;
    }

    //O(1)
    public void clear(){
        queue.clear();
    }




    //O(1)
    //return a string representative of the queue
    @Override
    public String toString(){
        return this.queue.toString();
    }



}

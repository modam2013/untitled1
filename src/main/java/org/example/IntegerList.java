package org.example;

public interface IntegerList {
    Integer add(String item);
  Integer add(int index,String item);
    Integer set(int index,String item);
    Integer remove(String item);

  Integer add(Integer item);

  Integer add(int index, Integer item);

  Integer set(int index, Integer item);

  Integer remove(Integer item);

  Integer remove(int index);
    boolean contains(String item);
    int indexOf(String item);

  boolean contains(Integer item);

  int indexOf(Integer item);

  int lastIndexOf(String item);

  int lastIndexOf(Integer item);

  Integer get(int index);
    boolean eguals(IntegerList other);
    int size();
    boolean isEmpty();
    void clear();
  Integer []toArray();
}

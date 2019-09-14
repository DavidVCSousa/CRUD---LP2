package Bussines.Controller;

import DataObject.DAO.BaseDAO;
import DataObject.VO.*;

import java.util.*;

  public class MyArrays {

    final  static public  List<User>     users    = new LinkedList<User>();
    final  static public  List<Product>  products = new LinkedList<Product>();
    final  static public  List<Order>    orders   = new LinkedList<Order>();
    final  static public  List<Client>   clients  = new LinkedList<Client>();

    public static void AddOnListWithID(BaseVO vo, Class c, List l)  {

            if(l.size()>0) {
                vo.setID(((BaseVO) l.get(l.size() - 1)).getID() + 1);
            }
            else{
                vo.setID(0);
            }

            l.add(c.cast(vo));
    }

    public static boolean UserExists(String login){

        for (User u: MyArrays.users) {
            if(login.equals(u.getLogin())) {
                return true;
            }
        }
        return  false;
    }

      public static Product FindProducts(String name){

          for (Product u: MyArrays.products) {
              if(u.getName().equals(name)) {
                  return u;
              }
          }
          return null;
      }
      public static Product FindProducts(int id){

          for (Product u: MyArrays.products) {
              if(u.getID() == (id)) {
                  return u;
              }
          }
          return null;
      }

      public static User FindUser(String name){

          for (User u: MyArrays.users) {
              if(u.getName().equals(name)) {
                  return u;
              }
          }
          return null;
      }
      public static User FindUser(int id){

          for (User u: MyArrays.users) {
              if(u.getID() == (id)) {
                  return u;
              }
          }
          return null;
      }

      public static Order FindOrder(int id){

          for (Order u: MyArrays.orders) {
              if(u.getID() == (id)) {
                  return u;
              }
          }
          return null;
      }

      public static Client FindClient(String name){

          for (Client u: MyArrays.clients) {
              if(u.getName().equals(name)) {
                  return u;
              }
          }
          return null;
      }
      public static Client FindClient(int id){

          for (Client u: MyArrays.clients) {
              if(u.getID() == (id)) {
                  return u;
              }
          }
          return null;
      }


  }

import java.util.Scanner;
import java.util.Date; 
class Library {
	
String name;
int rating;
String type;
boolean rented = false;
void getName() {
Scanner sc = new Scanner(System.in);
System.out.print("\n\nName: ");
String n = sc.next();
name = n;
}
void getRating() {
Scanner sc = new Scanner(System.in);
System.out.print("\nRating: ");
int r = sc.nextInt();
rating = r;
}
void getType() {
Scanner sc = new Scanner(System.in);
System.out.print("\nGenre: ");
String t = sc.next();
}
void getBook() {
rented = true;
}
void returnBook() {
rented = false;
}
boolean getRentStatus() {
if (rented) {
return true;
} else {
return false;
}
}
Library() {
getName();
getRating();
getType();
getRentStatus();
}
}
public class LibraryManage {
public static void main(String[] args) {
	try {
Date now = new Date();
System.out.println();
System.out.println(now);
@SuppressWarnings("resource")
Scanner sc = new Scanner(System.in);
System.out.print("\nTotal books to enter: ");
int total = sc.nextInt();
System.out.println("___________________________________\n");
Library album[] = new Library[total];
for (int i = 0; i < total; i++) {
Library temp = new Library();
album[i] = temp;
}
System.out.println("\nThere are " + total + " books! ");
System.out.println("------------------ Rent time! ---------------------\n");
for (int i = 0; i < total; i++) {
System.out.print("\nEnter your Book choice: ");
String name = sc.next();
if (name.equals("NONE")) {
break;
}
String bookName = album[i].name;
if (bookName.equals(name) && album[i].rented == false) {
album[i].getBook();
} else if (album[i].rented == true) {
System.out.println("\nSorry , " + album[i].name + "is rented !");
}else if(!bookName.equals(name)) {
	System.out.println(name+" This book is not in our library");
}
}
System.out.println("------------------ Return time ! ---------------------\n");
for (int i = 0; i < total; i++) {
System.out.print("\nenter Book you want to return: ");
String name = sc.next();
if (name.equals("NONE")) {
break;
}
String albumSongName = album[i].name;
if (albumSongName.equals(name)) {
album[i].returnBook();
} else {
System.out.println(name+" is not in the list! ");
}
}
for (int i = 0; i < total; i++) {
if (album[i].rented == true) {
System.out.println("\nThis book is rented: " + album[i].name);
}else {
	System.out.println("\nThis book is not rented: it is returned " + album[i].name);
}
}
	}catch(Exception e) {
		System.out.println(e+" Exception occured !");
	}
}
}

#include<iostream>
#include<fstream>
#include<cctype>
#include<iomanip>
using namespace std;



class coffee_shop
{
        int acno;
        char name[50];

        char type;

     public   void create_menu();  //function to get data from user
     public   void show_data() const;      //function to show data on screen
      public  void modify();  //function to add new data
      public  void report() const;    //function to show data in tabular format
      
     
};         


public void coffee_shop::create_menu()
{
        cout<<"\nEnter The account No. :";
        cin>>acno;
        cout<<"\n\nEnter The Name of The account Holder : ";
        cin.ignore();
        cin.getline(name,50);
        cout<<"\nEnter Type of The account (C/S) : ";
        cin>>type;
        type=toupper(type);
        cout<<"\nEnter The Initial amount(>=500 for Saving and >=1000 for current ) : ";
       
        cout<<"\n\n\nMenu  Created..";
}


// Welcome Method
public void welcome_to_coffee_shop()
{
        cout<<"\n\n\n\t  Welcome to Self Service coffee Shop System";
        cout<<"\n\n\tThis Page is Management System";
        cout<<"\n\n\t  SYSTEM";
        cout<<"\n\n\n\nCREATED BY : Mert Furkan Ergüden \n Mehmet Kubilay Elüstü \n Hazal Cengiz  ";
        cout<<"\n\nSCHOOL : Mugla Sıtkı Kocman University";
        cin.get();
}
// end of Welcome Method
 
public void coffee_shop::show_data() const
{
        cout<<"\nBeverages No. : "<<acno;
        cout<<"\nBeverage Price : ";
        cout<<name;
        cout<<"\nType of Beverage : "<<type;
        
}


public void coffee_shop::modify()
{
        cout<<"\nOrner Number. : "<<acno;
        cout<<"\nModify Beverage Number : ";
        cin.ignore();
        cin.getline(name,50);
        cout<<"\nModify Type of Beverage : ";
        cin>>type;
        type=toupper(type);
        cout<<"\nModify Balance amount : ";
         
}

        
 
        
 
        
public void coffee_shop::report() const
{	// Sipariş Raporu Çıktısı Oluşturur.
        cout<<acno<<setw(10)<<" "<<name<<setw(10)<<" "<<type<<setw(6)<<;
}

        
 


//***************************************************************
//      function declaration
//****************************************************************
public void create_order();   //function to write record in binary file
public void display_sp(int);   //function to display  order price
public void modify_order(int);       //function to modify order with beverage Number file
public void delete_order(int);       //function to delete order with order id by  record of file
public void display_all();             //function to display all order prices  details
public void new_order(int, int); // function to desposit/withdraw amount for given account
public void welcome_to_coffee_shop();   //welcome_to_coffee_shopductory screen function

//***************************************************************
//      THE MAIN FUNCTION OF PROGRAM
//****************************************************************


int main()
{
        char ch;
        int num;
        welcome_to_coffee_shop();
        do
        {
                system("cls");
                cout<<"\n\n\n\tMAIN MENU";    // Menüyü Listele
                cout<<"\n\n\t01. NEW ORDERT";  // Yeni Sipariş Oluştur Sipariş Numarası Girilir
                cout<<"\n\n\t02. COLD BEVERAGE "; // Soğuk içecekler 
                cout<<"\n\n\t03. WITHDRAW AMOUNT";  // Sıcak İçecekler
                cout<<"\n\n\t04. BALANCE ENQUIRY";  // Sipariş ödemeleri  için  Çalışan kodlar
                cout<<"\n\n\t05. ALL ACCOUNT HOLDER LIST";  // tüm sipariş tutarını göster
                cout<<"\n\n\t06. CLOSE AN ACCOUNT";  // sipariş penceresini kapat
                cout<<"\n\n\t07. MODIFY AN ACCOUNT"; // siparişleri düzenle
                cout<<"\n\n\t08. EXIT";
                cout<<"\n\n\tSelect Your Option (1-8) ";
                cin>>ch;
                system("cls");
                switch(ch)
                {
                case '1':
                        create_order();
                        break;
                case '2':
                        cout<<"\n\n\tEnter The Cold Beverage   Number . : "; cin>>num;
                        new_order(num, 1);
                        break;
                case '3':
                        cout<<"\n\n\tEnter The Hot Drinks Beverage Number : "; cin>>num;
                        deposit_withdraw(num, 2);
                        break;
                case '4': 
                        cout<<"\n\n\tEnter choose order payment type. : "; cin>>num;
                        display_sp(num);
                        break;
                case '5':
                         cout<<"\n\n\Display All Orders Price.  : "; cin>>num;
                        display_all();
                        break;
                case '6':
                        cout<<"\n\n\tClose to Order Window. : "; cin>>num;
                        delete_order(num);
                        break;
                 case '7':
                        cout<<"\n\n\tUpdate to Orders with Order Numbers. : "; cin>>num;
                        modify_order(num);
                        break;
                 case '8':
                        cout<<"\n\n\tThank you! System is off";
                        break;
                 default :cout<<"\a";
                }
                cin.ignore();
                cin.get();
        }while(ch!='8');
        return 0;
}


//***************************************************************
//      function to write in file witn Menu file
//****************************************************************

public void write_menu()
{       // write Menu on the system
        coffe_shop menu;
        ofstream outFile;
        outFile.open("menu.dat",ios::binary|ios::app);
        coffe_shop.create_menu();
        outFile.write(reinterpret_cast<char *> (&ac), sizeof(account));
        outFile.close();
}

//***************************************************************
//      function to read specific record from file
//****************************************************************

public void display_sp(int n)
{       //  Order Prices Toplam Sipariş Tutarı
        order_price price;
        bool flag=false;
        ifstream inFile;
        inFile.open("order_price.dat",ios::binary);
        if(!inFile)
        {
                cout<<"File could not be open !! Press any Key...";
                return;
        }
        cout<<"\nBALANCE DETAILS\n";

        while(inFile.read(reinterpret_cast<char *> (&price), sizeof(order_price)))
        {
                if(price.retacno()==n)
                {
                        price.show_data();
                        flag=true;
                }
        }
        inFile.close();
        
}


//***************************************************************
//      function to modify record of file
//****************************************************************

public void modify_order(int n)
{
        bool found=false;
        coffe_shop ac;
        fstream File;
        File.open("coffe_shop.dat",ios::binary|ios::in|ios::out);
        if(!File)
        {
                cout<<"File could not be open !! Press any Key...";
                return;
        }
        while(!File.eof() && found==false)
        {
                File.read(reinterpret_cast<char *> (&ac), sizeof(coffee_shop));
                if(ac.retacno()==n)
                {
                        ac.show_data();
                        cout<<"\n\nEnter The New Beverage Number"<<endl;
                        ac.modify();
                        int pos=(-1)*static_cast<int>(sizeof(coffee_shop));
                        File.seekp(pos,ios::cur);
                        File.write(reinterpret_cast<char *> (&ac), sizeof(coffee_shop));
                        cout<<"\n\n\t Orders Updated";
                        found=true;
                  }
        }
        File.close();
       
}

//***************************************************************
//      function to delete record of file
//****************************************************************


public void delete_order(int n)
{       // Delete Order  with Order ID by delete_order file
        coffee_shop ac;
        ifstream inFile;
        ofstream outFile;
        inFile.open("delete_order.dat",ios::binary);
        if(!inFile)
        {
                cout<<"File could not be open !! Press any Key...";
                return;
        }
        outFile.open("Temp.dat",ios::binary);
        inFile.seekg(0,ios::beg);
        while(inFile.read(reinterpret_cast<char *> (&ac), sizeof(coffee_shop)))
        {
                if(ac.retacno()!=n)
                {
                        outFile.write(reinterpret_cast<char *> (&ac), sizeof(coffee_shop));
                }
        }
        inFile.close();
        outFile.close();
        remove("delete_order.dat");
        rename("Temp.dat","delete_order.dat");
        cout<<"\n\n\tRecord Deleted ..";
}

//***************************************************************
//      function to display all accounts deposit list
//****************************************************************

public void display_all()
{        // Display All Menu On The System
        coffee_shop total_price ;
        ifstream inFile;
        inFile.open("all_products_menu.dat",ios::binary);
        if(!inFile)
        {
                cout<<"File could not be open !! Press any Key...";
                return;
        }
        cout<<"\n\n\t\tTotal Menu Lists\n\n";
        cout<<"====================================================\n";
        cout<<"A/c no.      Menu List           Type  Balance\n";
        cout<<"====================================================\n";
        while(inFile.read(reinterpret_cast<char *> (&ac), sizeof(coffee_shop)))
        {
                total_price.report();
        }
        inFile.close();
}

//***************************************************************
//      function to create new order
//****************************************************************

public void new_order(int n, int option)
{
        int amt;
        bool found=false;
        coffee_shop ac;
        fstream File;
        File.open("coffee_shop.dat", ios::binary|ios::in|ios::out);
        if(!File)
        {
                cout<<"File could not be open !! Press any Key...";
                return;
        }
        while(!File.eof() && found==false)
        {
                File.read(reinterpret_cast<char *> (&ac), sizeof(coffee_shop));
                if(ac.retacno()==n)
                {
                        ac.show_data();
                        if(option==1)
                        {
                                cout<<"\n\n\t Create New Order  ";
                                cout<<"\n\nEnter The Beverage Number";
                                cin>>amt;
                                ac.dep(amt);
                        }
                        File.write(reinterpret_cast<char *> (&ac), sizeof(coffee_shop));
                        cout<<"\n\n\t Order  Updated";
                        found=true;
               }
         }
        File.close();
        
}


 

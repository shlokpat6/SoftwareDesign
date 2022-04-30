import java.util.ArrayList;
import java.io.IOException;
import java.awt.event.*;

public class Driver
{
   public static void main(String []args)
   {
      Catalog catalog = new Catalog();
      boolean status = false;

      CatalogItemLoader loader = null;
      
      if (args.length > 0)
      {
         CatalogItemLoaderCSV loaderCSV = new CatalogItemLoaderCSV(args[0]);
         try
         {
            loaderCSV.loadItems();
         }
         catch (IOException e)
         {
            System.out.println("Could not load books from "+args[0]);
            return;
         }
         loader = loaderCSV;
      }
      else
      {
         CatalogItemLoaderInteractive loaderInteractive = new CatalogItemLoaderInteractive();
         try
         {
            loaderInteractive.loadItems();
         }
         catch (IOException e)
         {
            System.out.println("Could not load books iteractively");
         }
         loader = loaderInteractive;
      }

      ArrayList<CatalogItem> myBooks = loader.getItems();
      try
      {
          catalog = new Catalog(myBooks);
      }
      catch (IllegalArgumentException e)
      {
          System.out.println("could not load books: "+e.getMessage());
          catalog = new Catalog();
      }

	  //Instantiate a CatalogGUI object
      CatalogGUI ui = new CatalogGUI(500);
      
	  //Instantiate a CatalogController object
	  CatalogController catalogController = new CatalogController(catalog, ui);
      
      //Pairs the search button with an action
      ui.addSearchListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				catalogController.searchSpecificTerm(ui.getSearchTerm());
			}
	  });
	  
	  //Pairs the show all books button with an action
	  ui.addShowAllListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				catalogController.searchAllBooks();
			}
	  });
   }
}

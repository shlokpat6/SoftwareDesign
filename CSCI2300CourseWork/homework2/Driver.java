import java.util.ArrayList;

public class Driver{
	
	public static void main(String args[]) throws Exception{
		
		CatalogItemLoader catalogItemLoader= new CatalogItemLoader();
		catalogItemLoader = null;
		
		if(args.length>0)
		{
			CatalogItemLoaderCSV catalogItemLoaderCSV = new CatalogItemLoaderCSV(args[0]);
			
			try{
				catalogItemLoaderCSV.loadItems();
				catalogItemLoader = catalogItemLoaderCSV;
			}
			catch(Exception e)
			{
				System.out.println("Could not load books");
			}
			
			
		}else{
			
			CatalogItemLoaderInteractive catalogItemLoaderInteractive = new CatalogItemLoaderInteractive();
			try
			{
				catalogItemLoaderInteractive.loadItems();
				catalogItemLoader = catalogItemLoaderInteractive;
			}
			catch(Exception e)
			{
				System.out.println("Could not load books");
			}
			
			
		}
		try{
			ArrayList<CatalogItem> bookCatalog = catalogItemLoader.getItems();
			Catalog catalog = new Catalog(bookCatalog);
			ArrayList<String> booksByKate = catalog.search("Kate");
			System.out.println("Books by Kate");
			for(int i =0; i< booksByKate.size(); i++){
				System.out.println(catalog.getBook(booksByKate.get(i)));
			}	
		}catch(NullPointerException e){
			System.out.println("Null Pointer Exception Caught");
		}
		
		
	}
	
}

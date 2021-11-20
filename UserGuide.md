                                   Inventory Management Application user guide, by Jeanne Moore
<br />
This guide is meant to SUPPLEMENT the video guide created for this application. <br />
Please prioritize viewing that to get a better grasp of the utilization of this inventory <br />
application. <br />

ADD YOUTUBE LINK HERE

The user has access to multiple options with this Inventory Application, Including:
- Adding items
- Removing items
- Editing items
- Clearing all items
- Searching for items
- Sorting existing items:
- - By Name
- - By Serialnumber
- - By Value
- Loading or Saving an inventory from/to a file formatted:
As TSV (Tab Separated)
As JSON
As HTML


                                                         Adding an item
There are two ways of adding an item to inventory. The first method is to add a brand new item
To add a brand new item from inventory, fill the item name, serial number, and value text fields 
in the top right section of the app. The user must follow the specified format of input:
- Names must be between 2 and 256 characters
- Serial numbers must be of the format A-XXX-XXX-XXX 
where A can be only be an upper case letter and X can be either a letter or a number
In addition, serials cannot match those of items that already exist within the inventory
- Values must exceed 0 dollars and be of the format XXX.XX where X is a decimal digit.


The second method of adding items is to add an item that already exists. To do so, select the item you would like to
add from the table, then click the Add Button to increase the quantity of that item by one.


                                                        Removing an item
To remove an item from inventory, select the item from the table and click the Remove Button. If there are multiple of a single
item, this will reduce the quantity of that item by one.


                                                        Editing an item
To edit an item within inventory, select the item from the table, then type the name, serial number, and value you would like to
change. The new item effectively replaces the old one within inventory, while keeping the quantity it held.


                                                      Sorting the Inventory
To sort an inventory, the user may click the Sort Button. By default, the inventory will be sorted by the name of items, however
the user may select from the sort combo box whether to sort by name, by serial number, or by value instead.


                                                 Searching and Clearing the Inventory
To search for an item in inventory, a user may type in the name, and/or serial number of an item, then click the Search Button.
The inventory will scroll down to find the location of the item to display to the user.
To clear the inventory of all items, a user may simply click the Clear Button



                                                 Saving and Loading a list from file
To choose a file, click on the file button next to the Load Button to open a file chooser. The user may change the extension filter to
be a (.txt) Text file for TSV, a (.json) JSON file, or a (.html) HTML file. Clicking the save button will save the Inventory to that file,
and clicking the load button will load the Inventory stored in that file

COP3330 Fall 2021 Application Assignment 2 <br />
©Copyright 2021 Jeanne Moore

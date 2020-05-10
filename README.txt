Literature in the Age of Artificial Intelligence
Columbia University, Spring 2020
Final Project
Professor Dennis Tenen
Team: Erik Molin, Alexander Hiller, Elizabeth Merrigan, Andrew Marten Medina

Usage: java scriptReader <script-to-analyze>
Test with the "com.txt" file - this is the script of the pilot episode of the show "Community".
The picture "SS" is an example output of this script.

(This program is an MVP)

FUNCTIONALITY
1. This program takes one argument, the script to analyze.
2. From the existing database "props", it reads each item along with category and cost into a HashMap.
3. Then it reads the script and counts each occurence of an item that exists in the database.
4. It calculates the total cost of the script, along with total cost per item type and category.

BUGS
Calculates the wrong total cost per category.

LIMITS
Only reads .txt files to our knowledge

ADDITIONAL FEATURES TO WORK ON (IF TIME PERMITS)
- Support more file types.

- Hopefully we can find an effective and automated way of fetching words and costs associated with them (web scraper, ML, etc…).
- Can then expand to allowing the user to choose a preferred set of sources for the database 
(certain known prop or clothing websites, e-commerce sites like Amazon or Ebay, Google Shopping, etc.)

- We will use a database type that will work best for this project and might shift to a better version if we need it and time permits

- Expand this further to using semantic role labeling to identify new items to add to the database when reading new scripts,
and then if time permits look into ways (ML, AI) to automatically build the database while reading more scripts, 
making the program incrementally smarter and the database more extensive and optimized.

- More detailed information about the script

- Provide a more reliable “range” of prices for each item 
rather than attempting to pinpoint a precise estimate for the production cost. 
Allowing for a range would permit flexibility in production costs.
There could also be a feature where we offer alternatives to certain props or events that might be cheaper than what was originally decided. 
Maybe for each product, we could utilize an npm package that offers similar objects/events and then track the average prices of those, 
then shoot back alternative(s) that are cheaper.
We could develop a feature where the program returns the lines where the most “expensive” words appear.






#Potential Errors 

1. If you have a lastname firstname combination that repeats in the client sheet it will error out.
	- Add a number to the lastname or firstname for one of repeated occurences in the client sheet. 

#Software to Install

1. Java 
2. Eclipse 

See file called: JavaInstallationGuide.docx for links 

#Assumptions on Excel File 

1. Extension: .xlsx

#Assumptions on Images 

1. Entirely separate folder from everything else (otherwise the code will rename other files) 
2. In the right order (alpha numeric order) 
3. New file name structure: Lastname_Firstname.jpg
4. 1 image per client. The code basically matches the location of the image to the location of the name in the excel sheet. 


#Changes you need to make to the script 

In RenameJPEG.java (src/main/java/com.demo.JPEGProject) change the three paths. "\\" is necessary, cannot just be "\"


#Running the script 

Click on the script RenameJPEG
Click on the green Play button on the top (if you hover it should say "Run RenameJPEG")
It will finish running when you see <terminated> that the top of the console.

#Reverting back the name 

Check the excel sheet that is created when you run the script. The console should tell you what this file is called. 








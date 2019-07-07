Feature: Automated Test of Simple Application

@Sanity
Scenario Outline: Validate is the application executes as expected 
	When Check Is the application available in <Script_Path> with <Script> 
	Then User has access to application in <Script_Path> with <Script> 
	Then Run the application/script from <Python_path> with <Script_Path>,<Script> for <Application> with <Interval>  
	And wait for <Interval> minutes
	Then Check is the file available in <Script_Path> with <outputfile> 
	Then Check is the file available in <Script_Path> with <logfile> 
	Then Check is the file available in <Script_Path> with <tmpfile> 
	
	
	
	Examples: 
		|Script_Path|Script|Application|Interval|Python_path|outputfile|logfile|tmpfile|
		|"D:\Exec1\"|"Process_list_Details_windows_new.py"|"notepad"|"1"|"C:\\Python36\\python.exe"|"output.txt"|"processdetail.log"|"tmp_process_lst.txt"|
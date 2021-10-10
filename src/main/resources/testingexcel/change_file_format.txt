On Error Resume Next
Set objExcel = CreateObject("Excel.Application")

Dim filepath
filepath = WScript.Arguments.Item(0)

Set objWorkbook = objExcel.Workbooks.Open(filepath)

objExcel.DisplayAlerts = False
objExcel.ScreenUpdating = False
objExcel.Visible = False

objWorkbook.SaveAs filepath, FileFormat -4143
objWorkbook.Close False
objExcel.DisplayAlerts = True
objExcel.ScreenUpdating = True
objExcel.Visible = True

objExcel.quit
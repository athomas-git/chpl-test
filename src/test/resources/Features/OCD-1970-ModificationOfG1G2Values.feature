@Regression
Feature: OCD-1970 - Addition / modification of available G1/G2 values

Scenario Outline: Mapping legacy values for G1/G2
	Given I am on listing details page of listing with database ID "<DB_ID>"
	When I open details for criteria "<CRITERIA>"
	Then Measure Successfully Tested for "<gOption>" should display "<Measure_Name>" for "<CRITERIA>" 
	When I look at  Successfully Tested G1G2 Measures
	Then the "<Measure_Name>" shows Required Text as "<Required_Text>" and associated criteria as "<CRITERIA>"
	Examples:
    |DB_ID|CRITERIA|gOption|Measure_Name|Required_Text|
    |8481|170.315 (a)(1)|G2|Computerized Provider Order Entry - Medications: Eligible Provider|Required Test 10: Stage 2 Objective 3 Measure 1|
    |8481|170.315 (a)(1)|G2|Computerized Provider Order Entry - Medications: Eligible Provider|Required Test 10: Stage 3 Objective 4 Measure 1|
    |8481|170.315 (a)(2)|G2|Computerized Provider Order - Laboratory: Eligible Provider|Required Test 11: Stage 2 Objective 3 Measure 2|
    |8481|170.315 (a)(2)|G2|Computerized Provider Order - Laboratory: Eligible Provider|Required Test 11: Stage 3 Objective 4 Measure 2|
    |8481|170.315 (a)(3)|G2|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Provider|Required Test 12: Stage 2 Objective 3 Measure 3|
    |8481|170.315 (a)(3)|G2|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Provider|Required Test 12: Stage 3 Objective 4 Measure 3|   
    |9225|170.315 (a)(10)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Transition Objective 2 Measure 1|
    |9225|170.315 (a)(10)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Objective 2 Measure 1|  
    |8481|170.315 (a)(13)|G2|Patient-Specific Education: Eligible Provider|Required Test 3: Stage 2 Objective 6|
    |8481|170.315 (a)(13)|G2|Patient-Specific Education: Eligible Provider|Required Test 3: Stage 3 Objective 5 Measure 2|
    |8511|170.315 (b)(1)|G2|Patient Care Record Exchange:  Eligible Clinician|Required Test 7:  ACI Objective 5 Measure 1|
    |8511|170.315 (b)(1)|G2|Patient Care Record Exchange:  Eligible Clinician|Required Test 7: ACI Transition Objective 6 Measure 1|
    |8511|170.315 (b)(2)|G2|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9:  ACI Transition Objective 7 Measure 1|      
    |8511|170.315 (b)(2)|G2|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9: ACI Objective 5 Measure 3|
    |8511|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1:  ACI Objective 2 Measure 1|
    |8511|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Transition Objective 2 Measure 1|
    |8511|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Clinician Group|Required Test 9: ACI Objective 5 Measure 3|
    |8511|170.315 (g)(8)|G2|View, Download, or Transmit (VDT):  Eligible Clinician Individual (TIN/NPI)|Required Test 4: ACI Objective 4 Measure 1|     
	|8511|170.315 (g)(8)|G2|View, Download, or Transmit (VDT):  Eligible Clinician Group|Required Test 4: ACI Transition Objective 3 Measure 2|
	|8511|170.315 (g)(8)|G2|View, Download, or Transmit (VDT):  Eligible Provider Individual|Required Test 4: Stage 2 Objective 8 Measure 2|
	|8511|170.315 (g)(9)|G2|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 4: Stage 3 Objective 6 Measure 1|
	|8511|170.315 (g)(9)|G2|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 4: Stage 2 Objective 8 Measure 2|
	|8511|170.315 (g)(9)|G2|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 2: Stage 3 Objective 5 Measure 1|
	|9287|170.315 (e)(1)|G1|Patient Electronic Access:  Eligible Provider|Required Test 2: Stage 2 Objective 8 Measure 1|
	|9287|170.315 (e)(1)|G1|Patient Electronic Access:  Eligible Provider|Required Test 2: Stage 3 Objective 5 Measure 1|
	|8617|170.315 (e)(1)|G1|Patient Electronic Access:  Eligible Hospital/Critical Access Hospital|Required Test 2: Stage 2 Objective 8 Measure 1|
	|8617|170.315 (e)(1)|G1|Patient Electronic Access:  Eligible Hospital/Critical Access Hospital|Required Test 2:  Stage 3 Objective 5 Measure 1|
	
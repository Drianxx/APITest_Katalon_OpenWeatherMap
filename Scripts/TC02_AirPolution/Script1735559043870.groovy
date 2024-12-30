import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Kirim request
def response = WS.sendRequest(findTestObject('Air Polution'))

// Verifikasi status code
WS.verifyResponseStatusCode(response, 200)

// Parsing response body ke JSON
def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseBodyContent())

// Cek Body Tidak Null
assert jsonResponse != null : "Response body is null"
assert jsonResponse.list != null : "List data not found in response"


// Main
assert jsonResponse.list[0].main.aqi != null : "Air quality index is missing"

// Componenent
assert jsonResponse.list[0].components.co != null : "CO component is missing"
assert jsonResponse.list[0].components.no != null : "NO component is missing"
assert jsonResponse.list[0].components.no2 != null : "NO2 component is missing"
assert jsonResponse.list[0].components.o3 != null : "O3 component is missing"
assert jsonResponse.list[0].components.so2 != null : "SO2 component is missing"
assert jsonResponse.list[0].components.pm2_5 != null : "PM2_5 component is missing"
assert jsonResponse.list[0].components.pm10 != null : "PM10 component is missing"
assert jsonResponse.list[0].components.nh3 != null : "NH3 component is missing"
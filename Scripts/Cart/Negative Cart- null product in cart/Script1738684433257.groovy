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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.bstackdemo.com/signin')

WebUI.click(findTestObject('StackDemo/Login/select_username'))

WebUI.setText(findTestObject('StackDemo/Login/input_username'), 'demouser')

WebUI.sendKeys(findTestObject('StackDemo/Login/input_username'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('StackDemo/Login/select_password'))

WebUI.setText(findTestObject('StackDemo/Login/input_password'), 'testingisfun99')

WebUI.sendKeys(findTestObject('StackDemo/Login/input_password'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('StackDemo/Login/button_Log In'))

// Tunggu cart ter-update
//WebUI.delay(2)
WebUI.click(findTestObject('StackDemo/Cart/Cart_icon'))

String cartCount = WebUI.getText(findTestObject('StackDemo/Cart/check_cart'))

WebUI.verifyEqual(cartCount, '0', FailureHandling.CONTINUE_ON_FAILURE)

// Verifikasi warning
String warn = WebUI.getText(findTestObject('StackDemo/Cart/Total product 0'))

WebUI.verifyEqual(warn, '$ 0.00', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('StackDemo/Cart/Continue Shopping'))

WebUI.delay(2)

WebUI.verifyEqual(WebUI.getUrl(), 'https://www.bstackdemo.com/?signin=true')

WebUI.closeBrowser()


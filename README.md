Section 1
	Name: Shambhu Kumar
	Years of Experience: 10  years 1 months

Section 2: 
	Build IDE: Spring Tool Suite(Version: 3.9.1.RELEASE)
	JDK Version: java version "1.8.0_05"

Section 3 
How to Run Application
* Clone the source code from https://github.com/shamkuma/newsFeed
* Import in SpringToolSuite or Eclipse as “Import as maven Project”
* Run as -> maven Install(it will download all dependency”
* Right click on project and run as “Spring boot Application”
* Before Running the application please update database detail in dbconfig.properties
* Connect to your db (I’m using Oracle 11g Express) from sqlplus/sqldeveloper
* 
* Create Table Command given below

	create table newsfeed (
   news_id number(10) NOT NULL,
   news_content_type varchar2(15),
   news_priority number(1),
   news_time varchar2(12),
   news_heading varchar2(4000),
   news_content CLOB,
   ins_ts timestamp,
   CONSTRAINT news_id_pk PRIMARY KEY (news_id) ); 
*  Create Sequence query given below
  
  	CREATE SEQUENCE newsfeed_seq
	  MINVALUE 1
	  START WITH 1
	  INCREMENT BY 1
	  CACHE 20;


ScreenShot
Storing News to DB and or InMemory based on News Categroy

StoreNewsFeed(URL: http://localhost:8081/storeNewsFeed) Below are the Screen Shot link 
Input : ContentType:Sports and NewsPriority:1(Breaking News)
https://github.com/shamkuma/newsFeed/images/SaveScenario_Sports_BreakingNews.jpg



Input : ContentType:Finance and NewsPriority:1(Breaking News)
https://github.com/shamkuma/newsFeed/images/SaveScenario_Finance_BreakingNews.jpg




Input : ContentType:”General” and NewsPriority:1(Breaking News)
https://github.com/shamkuma/newsFeed/images/SaveScenario_General_BreakingNews.jpg


Input : ContentType:Finance and NewsPriority:2(General)
https://github.com/shamkuma/newsFeed/images/SaveScenario_General_GeneralNews.jpg


Input : ContentType:”Sports” and NewsPriority:2(General)
https://github.com/shamkuma/newsFeed/images/SaveScenario_Sports_GeneralNews.jpg



Input : ContentType:”General” and NewsPriority:2(General
https://github.com/shamkuma/newsFeed/images/SaveScenario_General_GeneralNews.jpg




OutPut
GetBreakingNews(URL: http://localhost:8081/getBreakingNews): will return 100 latest breaking news
https://github.com/shamkuma/newsFeed/images/GetBreakingNews.jpg


GetNews(URL: http://localhost:8081/getNews): User has to pass the Timestamp as Parameter
https://github.com/shamkuma/newsFeed/images/GetNews.jpg



Code Coverage ScreeShot
Timestamp as Parameter
https://github.com/shamkuma/newsFeed/images/CodeCoverage.jpg



Section 4 
Licensing 
a) THE CODE DOES NOT HAVE ANY COPYRIGHT WHATSOEVER. 
b) THE CODE IS NOT GOVERNED BY ANY LICENSES WHATSOEVER. 
c) THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR USERS OF THE CODE WOULD BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


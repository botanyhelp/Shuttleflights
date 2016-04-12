### Shuttleflights Android App README

Code for Shuttleflights android application.

Some tedious conversion from HTML to XML was done with python:
```{python}
from __future__ import print_function
import yaml
import re
from BeautifulSoup import BeautifulSoup
import urllib2

#file = open("shuttle_text.txt")
file = open("shuttle_sourcehtml.html.html2textWIDE")

i=0
docs=''
for line in file.readlines():
    i+=1
    line=line.rstrip()
    docs=""
    if i%2==0:
        #The first part of the "line", no newline
        print(line)
        #This part also has trailing citations, like this: "[22]"
        #pattern = re.compile(r'\[(\d{1,3})\]')
        #pattern = re.compile(r'(\d{1,3})')
        #pattern = re.compile(r'\[(\d{1,3})\]')
        #pattern = re.compile(r'\[(\d{1,3})\]')
        pattern = re.compile(r'(\d{1,3})')
        #m = re.search(r'\[(\d{1,3})\]',line)
        m = pattern.search(line)
        for citationNumber in m.groups():
            #print("___________________"+str(citationNumber),end='')
            url = str(citationNumber)
            print("url: "+url)
            html_page = urllib2.urlopen("http://127.0.0.1/"+url)
            soup = BeautifulSoup(html_page)
            for link in soup.findAll('a', attrs={'href': re.compile("^http://")}):
                #print(link.attrs, end='')
                #print(link.get('href'),end='')
                #docs+=str(link.get('href')).rstrip()
                docs+=str(link.get('href'))+"___"
    else:
        print(line,end='')
```
The first file has lines like these:
```
1   April 12, 1981  STS-1
Sts-1-patch.png
Columbia    2   02d 06h     Edwards First reusable orbital spacecraft flight; first flight of Columbia  [29] [30] [31]
2   November 12, 1981   STS-2
Sts-2-patch.png
Columbia    2   02d 06h     Edwards First reuse of a manned orbital space vehicle; first test of Canadarm robot arm; Truncated due to fuel cell problem.    [32] [33] [34]
3   March 22, 1982  STS-3
Sts3-patch.png
Columbia    2   08d 00h     White Sands Shuttle R&D flight, first and only landing at White Sands, New Mexico   [35] [36] [37]
```
The second file read by python has lines like this:
```
1   0412 !April 12, 1981     STS-1                         Columbia   2   02d 06h                             Edwards        First reusable orbital spacecraft flight; first flight of Columbia                                                                                                                                                                                                                [29] [30] [31]
                             [Sts-1-patch.png]
2   1112 !November 12, 1981  STS-2                         Columbia   2   02d 06h                             Edwards        First reuse of a manned orbital space vehicle; first test of Canadarm robot arm; Truncated due to fuel cell problem.                                                                                                                                                              [32] [33] [34]
                             [Sts-2-patch.png]
3   0322 !March 22, 1982     STS-3                         Columbia   2   08d 00h                             White Sands   Shuttle R&amp;D flight, first and only landing at White_Sands, New_Mexico                                                                                                                                                                                                         [35] [36] [37]
                             [Sts3-patch.png]
```
The python produces the data suitable for strings.xml, as advised in the [String Resources](http://developer.android.com/guide/topics/resources/string-resource.html) documentation.  These are the lines we want, the lines with the data that are in the application code:
```{xml}
    <string name="STS_1"><b>STS-1</b>\n\t<i>Flight Order: </i>1\n\t<i>Flight Date: </i>April 12, 1981\n\t<i>Mission</i>STS-1\n\t<i>Shuttle</i>Columbia\n\t<i>Crew: </i>2\n\t<i>Duration: </i>02d 06h\n\t<i>Rendezvous With/Landing Site: </i>Edwards\n\t<i>Notes and Sources: </i>First reusable orbital spacecraft flight; first flight of Columbia \n\n</string>
    <string name="STS_2"><b>STS-2</b>\n\t<i>Flight Order: </i>2\n\t<i>Flight Date: </i>November 12, 1981\n\t<i>Mission</i>STS-2\n\t<i>Shuttle</i>Columbia\n\t<i>Crew: </i>2\n\t<i>Duration: </i>02d 06h\n\t<i>Rendezvous With/Landing Site: </i>Edwards\n\t<i>Notes and Sources: </i>First reuse of a manned orbital space vehicle; first test of Canadarm robot arm; Truncated due to fuel cell problem. \n\nhttp://purl.fdlp.gov/GPO/gpo25159\n</string>
    <string name="STS_3"><b>STS-3</b>\n\t<i>Flight Order: </i>3\n\t<i>Flight Date: </i>3\nMarch 22, 1982\n\t<i>Mission</i>STS_3\n\t<i>Shuttle</i>Columbia\n\t<i>Crew: </i>2\n\t<i>Duration: </i>08d 00h\n\t<i>Rendezvous With/Landing Site: </i>White Sands\n\t<i>Notes and Sources: </i> Shuttle RandD flight, first and only landing at White_Sands, New_Mexico \n\nhttp://purl.fdlp.gov/GPO/gpo25159\nhttp://purl.fdlp.gov/GPO/gpo2515</string>
```
The data we were manipulating was pulled from a local semipreformatted data collection using a python web crawler:
```{python}
from BeautifulSoup import BeautifulSoup
import urllib2

url = "http://127.0.0.1/shuttle_sourcehtml.html"
#html = urllib2.urlopen("http://127.0.0.1/"+url)
html = urllib2.urlopen(url)

soup = BeautifulSoup(html)

table = soup.find("table")

#print entry
#rows = table.findAll('tr')[3]
rows = table.findAll('tr')
print(str(len(rows)))
for row in rows:
    cols = row.findAll('td')
    Order = cols[0].string
    Flight_date = cols[1].string
    Mission = cols[2].string
    Shuttle = cols[3].string
    Crew = cols[4].string
    Duration = cols[5].string
    Landing_Site = cols[6].string
    Notes = cols[7].string
    Sources = cols[8].string
    
    entry = (Order, Flight_date, Mission, Shuttle, Crew, Duration, Landing_Site, Notes, Sources)
    print entry
```
ImageMagick convert is always a friend when trimming graphics:
```{bash}
convert  -resize 240x240 -background white -gravity center -extent 240x240 STS-107_Flight_Insignia.png 240_STS-107_Flight_Insignia.png
convert  -resize 240x240 -background white -gravity center -extent 240x240 STS-115_patch.png 240_STS-115_patch.png
```

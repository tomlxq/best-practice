package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class GsWebixApplication {
    private static final Logger logger = LoggerFactory.getLogger(GsWebixApplication.class);

    @RequestMapping(value = {"", "/"})
    public String index() {
        logger.debug("########");
        //return "index";
        return "redirect:index.html";
    }

    @RequestMapping(value = {"/testjson"})
    public
    @ResponseBody
    String testjson(@RequestParam Integer id) {
        return "{ \"data\":[{\"id\":1,\"package\":\"acx100-source\",\"size\":\"229468\",\"architecture\":\"all\",\"section\":\"contrib\\/kernel\"},{\"id\":2,\"package\":\"falien-arena-browser\",\"size\":\"37128\",\"architecture\":\"all\",\"section\":\"contrib\\/games\"},{\"id\":3,\"package\":\"alien-arena-server\",\"size\":\"130272\",\"architecture\":\"i386\",\"section\":\"contrib\\/games\"},{\"id\":4,\"package\":\"alien-arena\",\"size\":\"579978\",\"architecture\":\"i386\",\"section\":\"contrib\\/games\"},{\"id\":5,\"package\":\"alsa-firmware-loaders\",\"size\":\"32758\",\"architecture\":\"i386\",\"section\":\"contrib\\/sound\"},{\"id\":6,\"package\":\"amoeba\",\"size\":\"94052\",\"architecture\":\"i386\",\"section\":\"contrib\\/x11\"},{\"id\":7,\"package\":\"atari800\",\"size\":\"763238\",\"architecture\":\"i386\",\"section\":\"contrib\\/otherosfs\"},{\"id\":8,\"package\":\"avifile-divx-plugin\",\"size\":\"950\",\"architecture\":\"i386\",\"section\":\"contrib\\/video\"},{\"id\":9,\"package\":\"avifile-win32-plugin\",\"size\":\"97404\",\"architecture\":\"i386\",\"section\":\"contrib\\/video\"},{\"id\":10,\"package\":\"avifile-xvid-plugin\",\"size\":\"928\",\"architecture\":\"i386\",\"section\":\"contrib\\/video\"},{\"id\":11,\"package\":\"b43-fwcutter\",\"size\":\"17094\",\"architecture\":\"i386\",\"section\":\"contrib\\/utils\"},{\"id\":12,\"package\":\"bgoffice-dict-downloader\",\"size\":\"6374\",\"architecture\":\"all\",\"section\":\"contrib\\/text\"},{\"id\":13,\"package\":\"cbedic\",\"size\":\"24864\",\"architecture\":\"i386\",\"section\":\"contrib\\/text\"},{\"id\":14,\"package\":\"chocolate-doom\",\"size\":\"304982\",\"architecture\":\"i386\",\"section\":\"contrib\\/games\"},{\"id\":15,\"package\":\"cl-sql-oracle\",\"size\":\"34340\",\"architecture\":\"all\",\"section\":\"contrib\\/lisp\"},{\"id\":18,\"package\":\"cltl\",\"size\":\"8874\",\"architecture\":\"all\",\"section\":\"contrib\\/doc\"},{\"id\":19,\"package\":\"crafty-books-medium\",\"size\":\"12890724\",\"architecture\":\"all\",\"section\":\"contrib\\/games\"},{\"id\":20,\"package\":\"crafty-books-medtosmall\",\"size\":\"1899430\",\"architecture\":\"all\",\"section\":\"contrib\\/games\"},{\"id\":21,\"package\":\"crafty-books-small\",\"size\":\"528438\",\"architecture\":\"all\",\"section\":\"contrib\\/games\"},{\"id\":22,\"package\":\"dosemu\",\"size\":\"2422360\",\"architecture\":\"i386\",\"section\":\"contrib\\/otherosfs\"},{\"id\":23,\"package\":\"dynagen\",\"size\":\"821012\",\"architecture\":\"all\",\"section\":\"contrib\\/net\"},{\"id\":24,\"package\":\"dynare-matlab\",\"size\":\"78422\",\"architecture\":\"all\",\"section\":\"contrib\\/math\"},{\"id\":25,\"package\":\"e-uae-dbg\",\"size\":\"3179146\",\"architecture\":\"i386\",\"section\":\"contrib\\/debug\"},{\"id\":26,\"package\":\"e-uae\",\"size\":\"946138\",\"architecture\":\"i386\",\"section\":\"contrib\\/otherosfs\"},{\"id\":27,\"package\":\"easyspice\",\"size\":\"67692\",\"architecture\":\"i386\",\"section\":\"contrib\\/electronics\"},{\"id\":28,\"package\":\"esix\",\"size\":\"47044\",\"architecture\":\"all\",\"section\":\"contrib\\/otherosfs\"},{\"id\":29,\"package\":\"exult-studio\",\"size\":\"577280\",\"architecture\":\"i386\",\"section\":\"contrib\\/games\"},{\"id\":30,\"package\":\"exult\",\"size\":\"978562\",\"architecture\":\"i386\",\"section\":\"contrib\\/games\"},{\"id\":31,\"package\":\"festvox-don\",\"size\":\"646986\",\"architecture\":\"all\",\"section\":\"contrib\\/sound\"},{\"id\":32,\"package\":\"festvox-rablpc16k\",\"size\":\"5359618\",\"architecture\":\"all\",\"section\":\"contrib\\/sound\"}], \"pos\":0, \"total_count\":999}";
    }
   /* <?xml version='1.0' encoding='utf-8' ?>
    <data parent='0' >
    <item id='1'  value='Layout branch' state='in progress' hours='120'>
        <item id='3'  value='Accordion' state='finalized' hours='42'></item>
        <item id='4'  value='Multiview' state='finalized' hours='34'></item>
    </item>
    <item id='2'  value='Data branch' state='in progress' hours='150'>
        <item id='5'  value='List' state='finalized' hours='50'></item>
    </item>
    <item id='6'  value='Calendar' state='planing' hours='0'>
    </item></data>*/
   @RequestMapping(value = {"/treetableStatic"})
   public
   @ResponseBody
   String treetableStatic() {//
       return "<?xml version='1.0' encoding='utf-8' ?>\n" +
               "    <data parent='0' >\n" +
               "    <item id='1'  value='Layout branch' state='in progress' hours='120'>\n" +
               "        <item id='3'  value='Accordion' state='finalized' hours='42'></item>\n" +
               "        <item id='4'  value='Multiview' state='finalized' hours='34'></item>\n" +
               "    </item>\n" +
               "    <item id='2'  value='Data branch' state='in progress' hours='150'>\n" +
               "        <item id='5'  value='List' state='finalized' hours='50'></item>\n" +
               "    </item>\n" +
               "    <item id='6'  value='Calendar' state='planing' hours='0'>\n" +
               "    </item></data>";
   }//
    @RequestMapping(value = {"/treetableDynamic"})
    public
    @ResponseBody  //parent=1&continue=true
    String treetableDynamic( @RequestParam(required = false) Integer parent,@RequestParam(name="continue",required = false) Boolean continue1) {//
        if(parent!=null&&parent.intValue()==1){
            return "<?xml version='1.0' encoding='utf-8' ?><data parent='1' ><item id='3'  value='Accordion' state='finalized' hours='42'></item><item id='4'  value='Multiview' state='finalized' hours='34'></item></data>";
        }else if(parent!=null&&parent.intValue()==2){
            return "<?xml version='1.0' encoding='utf-8' ?><data parent='2' ><item id='5'  value='List' state='finalized' hours='50'></item></data>";
        }else
        return "<?xml version='1.0' encoding='utf-8' ?>" +
                "<data parent='0' >" +
                "<item id='1'  value='Layout branch' state='in progress' hours='120' webix_kids='1'></item>" +
                "<item id='2'  value='Data branch' state='in progress' hours='150' webix_kids='1'></item>" +
                "<item id='6'  value='Calendar' state='planing' hours='0'>" +
                "</item>" +
                "</data>";
    }

    @RequestMapping(value = {"/loadjson"})
    @ResponseBody
    String loadjson( @RequestParam(required = false) String parent,@RequestParam(name="continue",required = false) Boolean continue1) {//
        if(parent!=null){
            return "{\"parent\":\""+parent+"\",\"data\":[{\"value\":\"Child 0 : x1\",\"id\":\"x-0-x1\"},{\"value\":\"Child 1 : x1\",\"id\":\"x-1-x1\"},{\"value\":\"Child 2 : x1\",\"id\":\"x-2-x1\"},{\"value\":\"Child 3 : x1\",\"id\":\"x-3-x1\"},{\"value\":\"Child 4 : x1\",\"id\":\"x-4-x1\"},{\"value\":\"Child 5 : x1\",\"id\":\"x-5-x1\"},{\"value\":\"Child 6 : x1\",\"id\":\"x-6-x1\"},{\"value\":\"Child 7 : x1\",\"id\":\"x-7-x1\"},{\"value\":\"Child 8 : x1\",\"id\":\"x-8-x1\"},{\"value\":\"Child 9 : x1\",\"id\":\"x-9-x1\"}]}";
            //return "{\"parent\":\""+parent+"\",\"data\":[{\"value\":\"Child 0 : x2\",\"id\":\"x-0-x2\"},{\"value\":\"Child 1 : x2\",\"id\":\"x-1-x2\"},{\"value\":\"Child 2 : x2\",\"id\":\"x-2-x2\"},{\"value\":\"Child 3 : x2\",\"id\":\"x-3-x2\"},{\"value\":\"Child 4 : x2\",\"id\":\"x-4-x2\"},{\"value\":\"Child 5 : x2\",\"id\":\"x-5-x2\"},{\"value\":\"Child 6 : x2\",\"id\":\"x-6-x2\"},{\"value\":\"Child 7 : x2\",\"id\":\"x-7-x2\"},{\"value\":\"Child 8 : x2\",\"id\":\"x-8-x2\"},{\"value\":\"Child 9 : x2\",\"id\":\"x-9-x2\"}]}"
        }else
            return "{\"total_count\":100000,\"pos\":0,\"data\":[{\"value\":\"record 0 : 0\",\"id\":\"x0\",\"webix_kids\":true},{\"value\":\"record 1 : 0\",\"id\":\"x1\",\"webix_kids\":true},{\"value\":\"record 2 : 0\",\"id\":\"x2\",\"webix_kids\":true},{\"value\":\"record 3 : 0\",\"id\":\"x3\",\"webix_kids\":true},{\"value\":\"record 4 : 0\",\"id\":\"x4\",\"webix_kids\":true},{\"value\":\"record 5 : 0\",\"id\":\"x5\",\"webix_kids\":true},{\"value\":\"record 6 : 0\",\"id\":\"x6\",\"webix_kids\":true},{\"value\":\"record 7 : 0\",\"id\":\"x7\",\"webix_kids\":true},{\"value\":\"record 8 : 0\",\"id\":\"x8\",\"webix_kids\":true},{\"value\":\"record 9 : 0\",\"id\":\"x9\",\"webix_kids\":true},{\"value\":\"record 10 : 0\",\"id\":\"x10\",\"webix_kids\":true},{\"value\":\"record 11 : 0\",\"id\":\"x11\",\"webix_kids\":true},{\"value\":\"record 12 : 0\",\"id\":\"x12\",\"webix_kids\":true},{\"value\":\"record 13 : 0\",\"id\":\"x13\",\"webix_kids\":true},{\"value\":\"record 14 : 0\",\"id\":\"x14\",\"webix_kids\":true},{\"value\":\"record 15 : 0\",\"id\":\"x15\",\"webix_kids\":true},{\"value\":\"record 16 : 0\",\"id\":\"x16\",\"webix_kids\":true},{\"value\":\"record 17 : 0\",\"id\":\"x17\",\"webix_kids\":true},{\"value\":\"record 18 : 0\",\"id\":\"x18\",\"webix_kids\":true},{\"value\":\"record 19 : 0\",\"id\":\"x19\",\"webix_kids\":true},{\"value\":\"record 20 : 0\",\"id\":\"x20\",\"webix_kids\":true},{\"value\":\"record 21 : 0\",\"id\":\"x21\",\"webix_kids\":true},{\"value\":\"record 22 : 0\",\"id\":\"x22\",\"webix_kids\":true},{\"value\":\"record 23 : 0\",\"id\":\"x23\",\"webix_kids\":true},{\"value\":\"record 24 : 0\",\"id\":\"x24\",\"webix_kids\":true},{\"value\":\"record 25 : 0\",\"id\":\"x25\",\"webix_kids\":true},{\"value\":\"record 26 : 0\",\"id\":\"x26\",\"webix_kids\":true},{\"value\":\"record 27 : 0\",\"id\":\"x27\",\"webix_kids\":true},{\"value\":\"record 28 : 0\",\"id\":\"x28\",\"webix_kids\":true},{\"value\":\"record 29 : 0\",\"id\":\"x29\",\"webix_kids\":true},{\"value\":\"record 30 : 0\",\"id\":\"x30\",\"webix_kids\":true},{\"value\":\"record 31 : 0\",\"id\":\"x31\",\"webix_kids\":true},{\"value\":\"record 32 : 0\",\"id\":\"x32\",\"webix_kids\":true},{\"value\":\"record 33 : 0\",\"id\":\"x33\",\"webix_kids\":true},{\"value\":\"record 34 : 0\",\"id\":\"x34\",\"webix_kids\":true},{\"value\":\"record 35 : 0\",\"id\":\"x35\",\"webix_kids\":true},{\"value\":\"record 36 : 0\",\"id\":\"x36\",\"webix_kids\":true},{\"value\":\"record 37 : 0\",\"id\":\"x37\",\"webix_kids\":true},{\"value\":\"record 38 : 0\",\"id\":\"x38\",\"webix_kids\":true},{\"value\":\"record 39 : 0\",\"id\":\"x39\",\"webix_kids\":true},{\"value\":\"record 40 : 0\",\"id\":\"x40\",\"webix_kids\":true},{\"value\":\"record 41 : 0\",\"id\":\"x41\",\"webix_kids\":true},{\"value\":\"record 42 : 0\",\"id\":\"x42\",\"webix_kids\":true},{\"value\":\"record 43 : 0\",\"id\":\"x43\",\"webix_kids\":true},{\"value\":\"record 44 : 0\",\"id\":\"x44\",\"webix_kids\":true},{\"value\":\"record 45 : 0\",\"id\":\"x45\",\"webix_kids\":true},{\"value\":\"record 46 : 0\",\"id\":\"x46\",\"webix_kids\":true},{\"value\":\"record 47 : 0\",\"id\":\"x47\",\"webix_kids\":true},{\"value\":\"record 48 : 0\",\"id\":\"x48\",\"webix_kids\":true},{\"value\":\"record 49 : 0\",\"id\":\"x49\",\"webix_kids\":true}]}";
    }
    public static void main(String[] args) {
        SpringApplication.run(GsWebixApplication.class, args);
    }
}

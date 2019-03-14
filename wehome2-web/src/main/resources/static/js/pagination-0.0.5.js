/**
 * Created by liangtong on 2018/10/30.
 * Email : liangtong@itcast.cn
 * 格式：
 *      <pages url=""  options="" show="" :params="" @callback=""></pages>
 *          必填项
 *              属性url：查询路径（内部自动进行ajax查询）
 *          扩展项：
 *              属性options：基本参数设置（内容需大括号）
 *                  pageSize : 每页显示个数（默认值2）
 *                  pageList：显示列表（默认值[2,4,8]）
 *                  preNum：当前页前将显示页面个数（默认值3）
 *                  nextNum：当前页后将显示页面个数（默认值3）
 *              属性show：拥有控制分页条显示
 *                  showAllNum ：是否显示所有的数字导航条（默认false，显示的是动态导航条）
 *              属性params：初始化查询条件【注意：必须冒号开头，此次的数据从vue的数据区域获得】
 *                  数据：必须是对象
 *                  例如：
 *                      new Vue({
 *                          data : {
 *                              user : {
 *                              }
 *                          }
 *                      });
 *              事件callback：查询成功后获得函数
 *                  数据：必须是函数（函数有一个参数，表示查询结果）
 *                  例如：
 *                      new Vue({
 *                          methods : {
 *                              show : function( data ){
 *                              }
 *                          }
 *                      });
 *              温馨提示：当从show获得查询结果后，可以进行数据遍历，但需要在data区域存放。
 *                  new Vue({
 *                      data : {
 *                          this.list = []              //存放查询结果
 *                      },
 *                      show : function(data){          //查询结果
 *                          this.list = data;
 *                      }
 *                  })
 *                  //标签遍历即可
 *                      <tr v-for="user in list">       //显示查询结果
 *                      </tr>
 *
 *
 * 实例：
 *      默认情况：
 *          <pages url="/user"  @callback="show"></pages>
 *      扩展项：
 *          <pages url="/user"  options="{pageSize:1,pageList:[1,2,4,8]}"  @callback="show"></pages>
 *
 *          <pages url="/user"  options="{pageSize:1,pageList:[1,2,4,8],preNum:2,nextNum:2}" @callback="show"></pages>
 *
 *          <pages url="/user"  options="{pageSize:1,pageList:[1,2,4,8]}" show="{showAllNum:true}" @callback="show"></pages>
 *
 *          <pages url="/user"  options="{pageSize:1,pageList:[1,2,4,8]}" show="{showAllNum:true}" :params="user" @callback="show"></pages>
 *
 *      条件查询：在使用分页条工具时，需要使用处理“条件查询”
 *          编写步骤：
 *              1.给查询按钮绑定click事件
 *              2.给分页条命名  <pages ref="名称">
 *              3.在绑定事件中执行固定代码
 *                  this.$refs.名称.czxy_findAll(1 , this.参数 );
 *          分析
 *              查询条件按钮需要绑定click事件，执行固定的代码
 *                  this.$refs.bookPage.czxy_findAll(1 , this.bookParam );
 *                  //调用分页条内部函数(第几页，条件)
 *                  //格式：this.$refs.引用名称.czxy_findAll( pageNum , params )
 *                 注意：在使用分页条时，必须命名
 *                     <pages ref="名称"></pages>
 *                      例如：
 *                          <pages url="/book" ref="bookPage"  @callback="show" :params="bookParam"></pages>
 */

Vue.component("pages",{
    template :`

        <nav aria-label="Page navigation">
            <div class="btn-group" style="vertical-align: top;">
              <button type="button" class="btn btn-default">{{pageSize}}</button>
              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                <li v-for="n in pageList" @click.prevent="changePageList(n)"><a href="#">{{n}}</a></li>
              </ul>
            </div>
            <ul class="pagination"  style="margin: 0;padding-left: 10px;">
                <li>
                    <a href="#" aria-label="Previous"  v-if="hasPreviousPage" @click.prevent="czxy_findAll(1)">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <li>
                    <a href="#" aria-label="Previous" v-if="hasPreviousPage" @click.prevent="czxy_findAll(prePage)" >
                        <span aria-hidden="true" >上一页</span>
                    </a>
                </li>
    

                <li v-for="i in numList" :class="{active:(i==pageNum)}">
                    <a href="#" @click.prevent="czxy_findAll(i)">{{i}}</a>
                </li> 

           
                <li>
                    <a href="#" aria-label="Next" v-if="hasNextPage" @click.prevent="czxy_findAll(nextPage)">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
                <li>
                    <a href="#" aria-label="Next" v-if="hasNextPage" @click.prevent="czxy_findAll(pages)">
                        <span aria-hidden="true">尾页</span>
                    </a>
                </li>
            </ul>
            
            
            
            <form class="form-inline" style="display: inline-block;vertical-align: top;padding-left: 20px;">
              <span>总共{{total}}条记录，当前第</span>
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" style="width: 70px;" v-model="goNum" @key.enter.prevent="goPage" placeholder="第几页">
                </div>
              </div>
              <span>/{{pages}}页</span>
              <button type="submit" class="btn btn-primary" @click.prevent="goPage">GO</button>
            </form>
            
        </nav>

    ` ,
    data : function(){
        return {
            "pageNum": 1,
            "pageSize" : 2 ,
            "total" : 1,
            "pageList" : [2,4,6],
            "pages": 2,                     //总分页数
            "prePage": 1,
            "nextPage": 1,
            "isFirstPage": true,
            "isLastPage": false,
            "hasPreviousPage": false,
            "hasNextPage": true,
            "start" : 1,
            "end" : 10,
            "preNum" : 3,                  //前面显示几个
            "nextNum" : 3,                //后面显示几个
            "numList" : [],
            "showAllNum" : false,       //显示数据导航
            "goNum" : 1

        }
    },
    methods : {
        /**
         * 查询所有
         * @param pageNum
         */
        czxy_findAll : function(pageNum){
            //拼凑条件
            var myurl = this.url + "?pageNum=" + pageNum + "&pageSize=" + this.pageSize;
            //拼凑条件
            if(this.params) {
                for(key in this.params){
                    myurl += "&" + key + "=" + this.params[key];
                }
            }
            axios.get(myurl).then(res => {

                //计算值
                this.calculateValue(pageNum, res.data.total);
                this.$emit( "callback" , res.data.list);
            });
        },
        /**
         * 计算分页数据
         * @param pageNum
         */
        calculateValue : function(pageNum , total){
            //当前页
            this.pageNum = pageNum;
            //跳转页面与当前页面同步
            this.goNum = this.pageNum;

            //总条数
            this.total = total;
            //总分页数
            //this.pages = (this.total + this.pageSize - 1) / this.pageSize;
            if(this.total % this.pageSize == 0 ){
                this.pages = this.total  / this.pageSize;
            } else {
                this.pages = Math.floor(this.total  / this.pageSize) + 1;
            }
            //前后页数
            this.prePage = Math.max(this.pageNum - 1 , 1 );
            this.nextPage = Math.min(this.pageNum + 1 , this.pages);
            //是否首尾页
            this.isFirstPage = this.pageNum == 1;
            this.isLastPage = this.pageNum == this.pages;
            //是否前后页
            this.hasPreviousPage = this.pageNum > 1;
            this.hasNextPage = this.pageNum < this.pages;

            //动态导航
            this.start = 1;
            this.end = this.start + this.preNum + this.nextNum;
            if(this.pages <= this.end){
                this.end = this.pages;
            } else {
                this.start = this.pageNum - this.preNum;
                this.end = this.pageNum + this.nextNum;

                if(this.start < 1){
                    this.start = 1;
                    this.end = this.start + this.preNum + this.nextNum;
                }

                if(this.end  > this.pages){
                    this.end = this.pages;
                    this.start = this.pages - this.preNum - this.nextNum;
                }
            }
            //动态导航，记录数据用于显示
            this.numList = [];
            if(this.showAllNum){
                for(var i = 1 ; i <= this.pages ; i ++){
                    this.numList.push( i );
                }
            } else {
                for(var i = this.start ; i <= this.end ; i ++){
                    this.numList.push( i );
                }
            }

        },
        changePageList : function(n){
            this.pageSize = n;
            this.czxy_findAll(1);
        },
        goPage : function(){
            if(! /^[\d]+$/g.test(this.goNum)){
                this.goNum = 1;
            }
            if(this.goNum < 1 || this.goNum > this.pages){
                this.goNum = 1;
            }
            this.czxy_findAll(this.goNum);
        }
    },
    props : {
        "url" : {
            required : true
        } ,
        "options": {

        },
        "show" : {

        },
        "params" :{

        }

    },
    created : function(){

        //处理参数数据
        if(this.options ){
            var _options = eval( "(" + this.options + ")");
            //TODO 不好使
            //Vue.util.mergeOptions(this , _options );
            if(_options.pageSize){
                this.pageSize = _options.pageSize;
            }
            if(_options.pageList){
                this.pageList = _options.pageList;
            }
            if(_options.preNum){
                this.preNum = _options.preNum;
            }
            if(_options.nextNum){
                this.nextNum = _options.nextNum;
            }
        }

        //处理显示数据
        if(this.show){
            var _show  = eval( "(" + this.show + ")");
            if( typeof(_show.showAllNum) == 'boolean'){
                this.showAllNum = _show.showAllNum;
            }
        }
        //跳转文本框的默认值
        this.goNum = this.pageNum;

        //页面加载查询第一页
        this.czxy_findAll( 1 );
    }
});

package com.imcys.bilibilias.tool_log_export.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.imcys.bilibilias.common.base.extend.launchIO
import dagger.hilt.android.AndroidEntryPoint
import jxl.format.Alignment
import jxl.format.Border
import jxl.format.BorderLineStyle
import jxl.write.Label
import jxl.write.WritableCell
import jxl.write.WritableCellFormat
import jxl.write.WritableFont
import jxl.write.WritableSheet
import kotlin.math.ceil
import com.imcys.bilibilias.tool_log_export.utils.ExcelUtils

@AndroidEntryPoint
class BangumiFollowLogActivity : AppCompatActivity() {

//    lateinit var binding: ActivityBangumiFollowLogBinding

//    var selectedLogHeaders = mutableListOf<BangumiFollowLogHeaderBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_bangumi_follow_log)
//        binding = DataBindingUtil.setContentView<ActivityBangumiFollowLogBinding?>(
//            this,
//            R.layout.activity_bangumi_follow_log,
//        )

        initView()
    }

    private fun initView() {
        // 加载追番基本信息（追番总数等）
//        loadBanguiFollowData()
        // 加载支持的表头的rv
//        loadDefaultLogHeaders()
        // 加载选中表头的rv
//        initSelectedLogHeaders()
        // 绑定完成按钮事件
//        bindingFinishEvent()
    }

    private fun bindingFinishEvent() {
//        binding.apply {
//            // 绑定完成
//            bangumiFollowLogFinishBt.setOnClickListener {
//                createExcel()
//            }
//        }
    }

    private fun createExcel() {
        // 获取追番总数和分页数（目前每页30条记录）

        val path = "/storage/emulated/0/Android/data/com.imcys.bilibilias/files/追番.xls"

        // 设置表头的字体大小和背景颜色
        val arial14font = WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD)
        arial14font.colour = jxl.format.Colour.LIGHT_BLUE
        val arial14format = WritableCellFormat(arial14font)
        // 居中方式
        arial14format.alignment = Alignment.CENTRE
        // 背景
        arial14format.setBorder(Border.ALL, BorderLineStyle.THIN)
        arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW)

        // 初始化一个excel表
        val workbook = ExcelUtils.initExcel(path)
        // 设置工作簿
        val sheet = workbook.createSheet("追番", 0)
        // 行高
        sheet.setRowView(0, 340)

        // 创建标题栏
//        selectedLogHeaders.forEachIndexed { index, bangumiFollowLogHeaderBean ->
//            sheet.addCell(
//                Label(
//                    index,
//                    0,
//                    bangumiFollowLogHeaderBean.title,
//                    arial14format,
//                ) as WritableCell?,
//            )
//            // 列宽
//            sheet.setColumnView(index, 300)
//        }

//        launchUI {
//            val loadTitle by lazy { mutableStateOf("开始获取数据") }
//            val loadDialog =
//                ExportDialogUtils.loadDialog(this@BangumiFollowLogActivity, loadTitle.value)
//                    .apply { show() }
//            for (i in 1..totalPage) {
//                loadTitle.value = "正在获取第${i}页"
//                launchIO { val bangumiFollowList = getBangumiFollowList(i) }
//                loadTitle.value = "正在存储第${i}页"
//                editExcel(bangumiFollowList, sheet, i - 1)
//            }
//            // 完成保存和写入
//            workbook.write()
//            workbook.close()
//
//            // 关闭弹窗
//            loadDialog.cancel()
//            // 弹出储存位置
//            asToast(
//                this@BangumiFollowLogActivity,
//                "获取成功\n储存位置" +
//                        "/storage/emulated/0/Android/data/com.imcys.bilibilias/files/追番.xls",
//            )
//        }
    }

    /**
     * 编辑excel
     */
//    private fun editExcel(bangumiFollowList: BangumiFollowList, sheet: WritableSheet, i: Int) {
//        sheet.apply {
//            val arial14font = WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD)
//            val arial10format = WritableCellFormat(arial14font)
//            arial10format.alignment = Alignment.CENTRE
//
//            selectedLogHeaders.forEachIndexed { selectIndex, bangumiFollowLogHeaderBean ->
//                when (bangumiFollowLogHeaderBean.harder) {
//                    Title -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.title, arial10format)
//                        }
//                    }
//
//                    SeasonID -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(
//                                selectIndex,
//                                row++,
//                                it.season_id.toString(),
//                                arial10format,
//                            )
//                        }
//                    }
//
//                    Evaluate -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.evaluate, arial10format)
//                        }
//                    }
//
//                    Summary -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.summary, arial10format)
//                        }
//                    }
//
//                    TotalCount -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(
//                                selectIndex,
//                                row++,
//                                it.total_count.toString(),
//                                arial10format,
//                            )
//                        }
//                    }
//
//                    Progress -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.progress, arial10format)
//                        }
//                    }
//
//                    Cover -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.cover, arial10format)
//                        }
//                    }
//
//                    SeasonTitle -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.season_title, arial10format)
//                        }
//                    }
//
//                    Subtitle -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.subtitle, arial10format)
//                        }
//                    }
//
//                    Subtitle14 -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEach {
//                            addCell(selectIndex, row++, it.subtitle_14, arial10format)
//                        }
//                    }
//
//                    SeasonTypeName -> {
//                        var row = if (i == 0) i + 1 else 30 * i
//                        bangumiFollowList.data.list.forEachIndexed { index, listBean ->
//                            addCell(
//                                selectIndex,
//                                row++,
//                                listBean.season_type_name,
//                                arial10format,
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private suspend fun getBangumiFollowList(pn: Int): BangumiFollowList {
//        return networkService.getBangumiFollow(asUser.mid, 1, pn, 30)
//    }
//
//    /**
//     * 初始化选定内容对话框
//     */
//    private fun initSelectedLogHeaders() {
//        binding.bangumiFollowLogSelectedLogHeadersRv.apply {
//            // 设置伸缩布局
//            val layoutManager = FlexboxLayoutManager(context)
//            layoutManager.flexDirection = FlexDirection.ROW
//            layoutManager.justifyContent = JustifyContent.FLEX_START
//            layoutManager.alignItems = AlignItems.CENTER
//            this.layoutManager = layoutManager
//
//            this.setup {
//                // 防抖动
//                addType<BangumiFollowLogHeaderBean>(R.layout.log_export_item_bangumi_header)
//                onClick(R.id.log_export_item_bangumi_log_header_ly) {
//                    selectedLogHeaders.remove(getModel())
//                    defaultLogHeaders.add(getModel())
//
//                    binding.bangumiFollowLogDefaultLogHeadersRv.setDifferModels(defaultLogHeaders + mutableListOf())
//                    binding.bangumiFollowLogSelectedLogHeadersRv.setDifferModels(selectedLogHeaders + mutableListOf())
//                }
//            }
//        }
//    }
//
//    /**
//     * 加载默认可选表头
//     */
//    private fun loadDefaultLogHeaders() {
//        binding.bangumiFollowLogDefaultLogHeadersRv.apply {
//            // 设置伸缩布局
//            val layoutManager = FlexboxLayoutManager(context)
//            layoutManager.flexDirection = FlexDirection.ROW
//            layoutManager.justifyContent = JustifyContent.FLEX_START
//            layoutManager.alignItems = AlignItems.CENTER
//            this.layoutManager = layoutManager
//
//            this.setup {
//                addType<BangumiFollowLogHeaderBean>(R.layout.log_export_item_bangumi_header)
//
//                onClick(R.id.log_export_item_bangumi_log_header_ly) {
//                    defaultLogHeaders.remove(getModel())
//                    selectedLogHeaders.add(getModel())
//
//                    binding.bangumiFollowLogDefaultLogHeadersRv.setDifferModels(defaultLogHeaders + mutableListOf())
//                    binding.bangumiFollowLogSelectedLogHeadersRv.setDifferModels(selectedLogHeaders + mutableListOf())
//                }
//            }.models = defaultLogHeaders + mutableListOf()
//        }
//    }
//
//    /**
//     * 加载番剧情况
//     */
//    private fun loadBanguiFollowData() {
//        launchUI {
//            bangumiFollowList = networkService.getBangumiFollow(asUser.mid, 1, 1, 15)
//            if (bangumiFollowList.code == 0) {
//                binding.bangumiFollowList = bangumiFollowList
//            }
//        }
//    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, BangumiFollowLogActivity::class.java)
            context.startActivity(intent)
        }
    }
}

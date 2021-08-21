import com.google.gson.annotations.SerializedName

data class CatalogItem (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("data") val data : List<CatalogItemData>,
	@SerializedName("data_type") val dataType : String,
	@SerializedName("show_title") val showTitle : Boolean,
	@SerializedName("ui_type") val uiType : String,
	@SerializedName("row_count") val rowCount : Int
)
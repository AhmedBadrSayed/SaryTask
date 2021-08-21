import com.google.gson.annotations.SerializedName


data class CatalogItemData (

	@SerializedName("group_id") val group_id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("image") val image : String,
	@SerializedName("empty_content_image") val emptyContentImage : String,
	@SerializedName("empty_content_message") val emptyContentMessage : String,
	@SerializedName("has_data") val has_data : Boolean,
	@SerializedName("show_unavailable_items") val showUnavailableItems : Boolean,
	@SerializedName("show_in_brochure_link") val showInBrochureLink : Boolean
)
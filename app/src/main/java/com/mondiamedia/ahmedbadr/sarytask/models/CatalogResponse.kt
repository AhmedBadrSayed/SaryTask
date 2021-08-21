import com.google.gson.annotations.SerializedName

data class CatalogResponse (

	@SerializedName("result") val catalogItemsList : List<CatalogItem>,
	@SerializedName("other") val other : Other,
	@SerializedName("message") val message : String,
	@SerializedName("status") val status : Boolean
)
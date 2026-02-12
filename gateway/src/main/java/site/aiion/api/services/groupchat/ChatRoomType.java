package site.aiion.api.services.groupchat;

/**
 * 명예도에 따른 단체채팅방 등급.
 * 실버(0~99) / 골드(100~499) / 플래티넘(500~999) / 다이아(1000+)
 */
public enum ChatRoomType {
    SILVER,   // 0-99
    GOLD,     // 100-499
    PLATINUM, // 500-999
    DIAMOND;  // 1000+

    public static ChatRoomType fromHonor(int honor) {
        if (honor >= 1000) return DIAMOND;
        if (honor >= 500) return PLATINUM;
        if (honor >= 100) return GOLD;
        return SILVER;
    }
}

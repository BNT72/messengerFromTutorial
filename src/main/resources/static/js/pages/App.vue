<template>
  <v-app>
<!--   <v-toolbar >-->
      <v-app-bar app>
      <v-toolbar-title>Vk</v-toolbar-title>
      <v-spacer></v-spacer>
        <span v-if="profile">{{ profile.name }}&nbsp;</span>
      <v-btn v-if="profile" icon href="/logout">
        <v-icon>{{ logout }}</v-icon>
      </v-btn>
      </v-app-bar>
<!--    </v-toolbar>-->
    <v-main>
      <v-container v-if="!profile">Необходимо авторизоваться через
        <a href="/login">Google</a>
      </v-container>
      <v-container v-if="profile">
        <messages-list :messages="messages"/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import MessagesList from 'components/messages/MessageList.vue'
import {addHandler} from 'util/ws';
import {getIndex} from 'util/collections';
import { mdiExitToApp } from '@mdi/js'
export default {
  components: {
    MessagesList
  },
  data() {
    return {
      messages: frontendData.messages,
      profile: frontendData.profile,
      logout: mdiExitToApp
    }
  },
  created() {
    addHandler(data => {
      let index = getIndex(this.messages, data.id)
      if (index > -1) {
        this.messages.splice(index, 1, data);
      } else {
        this.messages.push(data)
      }
    })
  }
}
</script>

<style>

</style>

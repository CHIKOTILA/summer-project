<template>
  <div id="task-descr">
    {{task.description}}
    <div v-for="(example,n) in task.examples" :key="n" class="task-example">
      <h5>Пример {{ n + 1 }}</h5>
      <div class="task-example-wrapper">
        <code>Входные параметры:</code> <code >{{ example.input }}&nbsp;</code>
        <br>
        <code>Выходные параметры:</code>  <code>{{ example.output }}</code>
      </div>
    </div>
    <div class="task-limits"><h5>Ограничения</h5>
      <ul>
        <li><h5>время выполнения {{ task.timeLimit }} ms</h5></li>
        <li><h5>объем памяти {{ task.volumeLimit }} MB</h5></li>
      </ul>
    </div>
  </div>
</template>

<script setup>
defineProps(['task'])
</script>

<style lang="scss" scoped>
#task-descr {

}

.task-example {
  margin-top: 30px;

  &-wrapper {
    background-color: var(--color-background-soft);
    padding: 10px 30px;
    border-radius: 10px;
  }
}


code {
  font-size: 16px;
}

@media (max-width: 650px) {
code {
  font-size: 14px;
}
  h5 {
    font-size: 14px;
  }
}
</style>